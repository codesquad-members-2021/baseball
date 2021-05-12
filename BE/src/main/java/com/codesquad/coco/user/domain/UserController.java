package com.codesquad.coco.user.domain;

import com.codesquad.coco.user.UserService;
import com.codesquad.coco.utils.FindSecretServerKey;
import com.gitoauth.coco.JWT.JWTUtils;
import com.gitoauth.coco.oauth.AccessToken;
import com.gitoauth.coco.oauth.Oauth;
import com.gitoauth.coco.oauth.UserInfoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

import static com.codesquad.coco.user.domain.GitURI.*;

@RestController
public class UserController {

    private UserService userService;
    private SecretServerKey secretServerKey = FindSecretServerKey.find();
    private String key = Base64.getEncoder().encodeToString(secretServerKey.serverSecretToByteArray());
    private Oauth oauth = new Oauth(secretServerKey.getClientId(),
            secretServerKey.getClientSecret(),
            REDIRECT_URI.getUri(),
            ACCESS_TOKEN_URI.getUri(),
            AUTHORIZE_URI.getUri(),
            USER_INFO_URI.getUri()
    );

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String jwt = request.getHeader("Authorization");
        if (jwt != null) {
            JWTUtils.validateJWT(jwt, key);
            return;
        }
        oauth.requestCode(response);
    }

    @GetMapping("/login/github")
    @ResponseStatus(HttpStatus.OK)
    public void callBack(@RequestParam("code") String code, HttpServletResponse response) {
        AccessToken accessToken = oauth.requestAccessToken(code);
        UserInfoDTO userInfoDTO = oauth.requestUserInfo(accessToken);

        userService.insertUser(userInfoDTO, accessToken);

        String jwt = JWTUtils.createJWTTypeBearer(userInfoDTO.getId(), key);

        response.setHeader("Authorization", jwt);

        return;
    }

    //todo : 리프레쉬  토큰 받아오기, 밑 다시 세팅
}
