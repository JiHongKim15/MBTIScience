package com.mbti.user.user.service;

import com.mbti.user.user.dto.OAuthAttributes;
import com.mbti.user.user.dto.SessionUser;
import com.mbti.user.user.dto.UserDto;
import com.mbti.user.user.entity.UserEntity;
import com.mbti.user.user.entity.UserMapper;
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

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final HttpSession httpSession;
    private final UserService userService;

    private final UserRepository userRepository;
    private final UserMapper userMapper;


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

        //이미 존재하는 회원인 경우 로그인 -> 로그인 실패 && 새로운 회원인 경우 회원가입 유무를 물어봐야 함
        //회원가입을 할 것이라는 정보를 어떻게 알 수 있는가?
        //일단 oauth2로 정보를 저장하고, 회원가입 시 덮어쓰기?
        if(user == null){
            //화면에서 회원가입을 진행할 것인지 물어본다.
            return null;
        }

        UserDto userDto = this.saveOrUpdate(attributes); //저장 및 업데이트 진행
        httpSession.setAttribute("user", new SessionUser(userDto));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(userDto.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private UserDto saveOrUpdate(OAuthAttributes attributes) {

        String uuid = userService.retrieveUserEmailUUIDByEmail(attributes.getEmail());

        UserEntity userEntity = userRepository.findByUuid(uuid)
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userMapper.toUserDto(userRepository.save(userEntity));
    }

}