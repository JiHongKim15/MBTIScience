import React, {Component} from 'react';
import { GOOGLE_AUTH_URL, NAVER_AUTH_URL, KAKAO_AUTH_URL, ACCESS_TOKEN } from '../constants'
import googleLogo from '../img/google-logo.png';
import kakaoLogo from '../img/kakao-logo.png';
import naverLogo from '../img/naver-logo.png';
import './Login.css';

class SocialLogin extends Component {
    render() {
        return (
            <div className="social-login">
                <a className="btn btn-block social-btn google" href={GOOGLE_AUTH_URL}>
                    <img src = {googleLogo} alt="Google" /> Log in with Google</a>
                <a className="btn btn-block social-btn naver" href={NAVER_AUTH_URL}>
                    <img src = {naverLogo} alt ="Naver" /> Log in with Naver</a>
                <a className="btn btn-block social-btn kakao" href={KAKAO_AUTH_URL}>
                    <img src = {kakaoLogo} alt="Kakao" /> Log in with Kakao</a>
            </div>
        );
    }
}

export default SocialLogin;