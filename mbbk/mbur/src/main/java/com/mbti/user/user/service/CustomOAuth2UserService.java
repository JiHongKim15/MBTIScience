package com.mbti.user.user.service;

import com.mbti.user.exception.BusinessException;
import com.mbti.user.user.dto.OAuthAttributes;
import com.mbti.user.user.dto.SessionUser;
import com.mbti.user.user.entity.UserEntity;
import com.mbti.user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserRepository userRepository;
    private final HttpSession httpSession;
    private final UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.debug("Oauth2 로그인");
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        //이미 존재하는 회원인 경우 로그인 -> 로그인 실패 && 새로운 회원인 경우 회원가입 유무를 물어봐야 함
        if(!login(attributes)){
            //attributes -> 회원가입 하겠다 -> API
            //1. 우선적으로 DB에 저장 후, 회원가입을 하지 않겠다면 DB에서 삭제
            //2. 자체 토큰
            //3. 토근 검증이 가능한 지
        }
        UserEntity userEntity = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(userEntity));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(userEntity.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private UserEntity saveOrUpdate(OAuthAttributes attributes) {
        UserEntity userEntity = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userRepository.save(userEntity);
    }

    private boolean login(OAuthAttributes attributes){
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByEmail(attributes.getEmail())
                .orElseThrow(() -> new BusinessException("사용자 정보를 가져오는 도중 오류가 발생하였습니다.")));

        if(!user.isPresent()){
            return false;
        }

        return true;
    }

}