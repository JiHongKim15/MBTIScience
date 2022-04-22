import React, {Component} from 'react';
import LoginButtonGoogle from "../../components/NaverLoginButton";
import {GoogleLoginButton} from 'react-social-login-buttons';
//import NaverLoginButton from "../../components/NaverLoginButton";
//import KakaoLoginButton from "../../components/KakaoLoginButton";

class LoginPage extends Component {
    render() {
        return (
            <div className="LoginPage">
                < GoogleLoginButton />
            </div>
        );
    }
}

export default LoginPage;