import React, {Component} from 'react';
import axios from "axios";
import NaverLoginButton from "../../components/NaverLoginButton";
import {GoogleLoginButton} from 'react-social-login-buttons';
import SocialLoginButton from '../../components/SocialLoginButton';
//import NaverLoginButton from "../../components/NaverLoginButton";
//import KakaoLoginButton from "../../components/KakaoLoginButton";

class LoginPage extends Component {

    socialLogin = () => {
        axios.get('http://localhost:8082/oauth2/authorization/google')
        .then( () => {
            console.log("로그인 성공");
        })
        .catch( (error) => {
            console.log(error.response);
        })
        .finally( () => {
            console.log("로그인 됐나?");
        })
    };

    render() {
        return (
            <div className="LoginPage"> 
                < button onClick={this.socialLogin}/>
            </div>
        );
    }
}

export default LoginPage;