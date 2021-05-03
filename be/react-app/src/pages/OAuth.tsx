import React from "react";
import Box from "@material-ui/core/Box";
import { GoogleLogin } from "react-google-login";

export const OAuth = () => (
  <Box>
    <GoogleLogin
      clientId="google-login-key"
      onSuccess={(result) => {
        alert("로그인 성공");
        console.log(result);
      }}
      onFailure={(result) => {
        alert("로그인 실패");
        console.log(result);
      }}
      cookiePolicy={"single_host_origin"}
    />
  </Box>
);
