import { Button } from "react-bootstrap";
import LoginButtonGoogle from "../components/NaverLoginButton";

import {GoogleLoginButton} from 'react-social-login-buttons';
import NaverLoginButton from "../components/NaverLoginButton";

function LoginPage() {
    const socialLogin = () => {
        
    };
    return (
        <div className="LoginPage">
            Login
            < GoogleLoginButton onClick = { ( ) =>  alert( ' google Button' ) } />
            < NaverLoginButton onClick = { ( ) =>  alert( ' naver Button' ) } />
        </div>
    );
}

export default LoginPage;