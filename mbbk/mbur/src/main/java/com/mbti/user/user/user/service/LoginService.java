package com.mbti.user.user.user.service;

import com.mbti.user.user.user.dto.SessionUser;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final HttpSession httpSession;

    public void loginGoogle(SessionUser sessionUser) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return;
    }

    public void loginNaver(SessionUser sessionUser) {
    }

    public void loginKakao(SessionUser sessionUser) {
    }

    public void logout(SessionUser sessionUser) {
        log.info("logout 테스트");
        log.info(sessionUser.getEmail());
    }
}
