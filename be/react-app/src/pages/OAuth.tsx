import React from "react";
import Box from "@material-ui/core/Box";
import { useSnackbar } from "notistack";
import { GoogleLogin } from "react-google-login";

export const OAuth = () => {
  const { enqueueSnackbar } = useSnackbar();

  return (
    <Box>
      <GoogleLogin
        clientId="google-login-key"
        onSuccess={(result) => {
          enqueueSnackbar("로그인 성공", { variant: "success" });
          console.log(result);
        }}
        onFailure={(result) => {
          enqueueSnackbar("로그인 실패", { variant: "error" });
          console.log(result);
        }}
        cookiePolicy={"single_host_origin"}
      />
    </Box>
  );
};
