import React, {Component} from 'react';
import axios from "axios";
import { createButton } from "react-social-login-buttons";



type buttonConfig = {
    social: String;
    url: String;
}

const naverConfig = {
    text: "Log in with Naver",
    iconFormat: (name: string) => `fa fa-${name}`,
    style: { background: "#03C75A" },
    activeStyle: { background: "#293e69" }
};

const NaverLoginButton = createButton(naverConfig);

const kakaoConfig = {
    text: "Log in with Kakao",
    iconFormat: (name: string) => `fa fa-${name}`,
    style: { background: "#FEE500", color: "#000000" },
    activeStyle: { background: "#293e69" }
  };
const KakaoLoginButton = createButton(kakaoConfig);

class SocialLoginButton extends Component<buttonConfig> {

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

    rander(){
        return (
            <div>
                <button onClick = {this.socialLogin}/>
            </div>
        );
    }
    
}

export default SocialLoginButton;