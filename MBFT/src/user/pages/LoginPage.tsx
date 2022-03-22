import { Button } from "react-bootstrap";
import LoginButtonGoogle from "../components/NaverLoginButton";
import axios from "axios";
import {GoogleLoginButton} from 'react-social-login-buttons';
import NaverLoginButton from "../components/NaverLoginButton";

function LoginPage() {
    const socialLogin = () => {
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
    return (
        <div className="LoginPage">
            Login
            < GoogleLoginButton onClick = { ( ) =>  
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
         } />
            < NaverLoginButton onClick = { ( ) =>  alert( ' naver Button' ) } />
        </div>
    );
}

export default LoginPage;