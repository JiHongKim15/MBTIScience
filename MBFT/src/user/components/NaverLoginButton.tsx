import React from 'react';
import {createButton} from "react-social-login-buttons";
import naverIcon from "../../assests/icon/naver_icon.png";

const config = {
  text: "Log in with Naver",
  icon: naverIcon,
  iconFormat: (name: string) => `fa fa-${name}`,
  style: { background: "#03C75A" },
  activeStyle: { background: "#293e69" }
};
/** My Facebook login button. */
const NaverLoginButton = createButton(config);

export default NaverLoginButton;