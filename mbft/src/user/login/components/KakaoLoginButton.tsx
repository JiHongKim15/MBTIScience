import React from 'react';
import {createButton} from "react-social-login-buttons";
import kakaoIcon from "../../assests/icon/kakao_icon.png";


const config = {
  text: "Log in with Kakao",
  icon: kakaoIcon,
  iconFormat: (name: string) => `fa fa-${name}`,
  style: { background: "#FEE500", color: "#000000" },
  activeStyle: { background: "#293e69" }
};
const KakaoLoginButton = createButton(config);

export default KakaoLoginButton;