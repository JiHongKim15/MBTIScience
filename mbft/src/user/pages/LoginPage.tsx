import React, {Component} from 'react';
import {GoogleLoginButton} from 'react-social-login-buttons';

import SocialLogin from '../login/components/SocialLogin';

class LoginPage extends Component {
    render() {
        return (
            <div className="LoginPage">
                < SocialLogin />
            </div>
        );
    }
}

export default LoginPage;