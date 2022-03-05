package com.mbti.user.user.user.service;

import com.mbti.user.user.user.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    public void loginGoogle(SessionUser sessionUserser) {
        /* TOBE: 수정필요
        model.addAttribute("posts", postsService.findAllDesc());

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null){
            model.addAttribute("userName", user.getName());
        }*/
        return;
    }

    public void loginNaver(SessionUser sessionUser) {
    }

    public void loginKakao(SessionUser sessionUser) {
    }
}
