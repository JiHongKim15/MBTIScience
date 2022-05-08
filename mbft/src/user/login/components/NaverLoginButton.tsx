import React from 'react';
import { createButton } from "react-social-login-buttons";

const config = {
  text: "Log in with Naver",
  iconFormat: (name: string) => `fa fa-${name}`,
  style: { background: "#03C75A" },
  activeStyle: { background: "#293e69" }
};

const NaverLoginButton = createButton(config);

export default NaverLoginButton;