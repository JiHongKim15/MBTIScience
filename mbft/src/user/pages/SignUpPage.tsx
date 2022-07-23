import React, {Component} from 'react';
import {GoogleLoginButton} from 'react-social-login-buttons';

import SocialLogin from '../login/components/SocialSignUp';

class SignUpPage extends Component {
    render() {
        return (
            <div className="SignUp">
                < SocialLogin />
            </div>
        );
    }
}

export default SignUpPage;