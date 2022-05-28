package com.mbti.user.user.service;

import com.mbti.user.exception.BusinessException;
import com.mbti.user.user.dto.OAuthAttributes;
import com.mbti.user.user.dto.SessionUser;
import com.mbti.user.user.dto.UserDto;
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


        UserDto user = userService.retrieveUserByEmail(attributes.getEmail());

        /*
        TODO: null check를 어떤 형식으로 하는 것이 좋을까?
        1. optional: 비용이 비싸다는 문제 발생
        2. null utils 생성: 가장 많이 사용하는 방식
        3. equals, == null 사용
         */

        //이미 존재하는 회원인 경우 로그인 -> 로그인 실패 && 새로운 회원인 경우 회원가입 유무를 물어봐야 함
        if(user == null){
            //화면에서 회원가입을 진행할 것인지 물어본다.
            return null;
        }

        UserEntity userEntity = this.saveOrUpdate(attributes); //저장 및 업데이트 진행
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

    /*
    TODO: 구글 = 카카오 = 네이버로 로그인을 모두 같게 연동한다면, email이 key 값이 될 수 있을까?
     */

}