package team9.baseball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team9.baseball.DTO.response.ApiResult;
import team9.baseball.domain.enums.ResourceServer;
import team9.baseball.service.OauthService;
import team9.baseball.service.UserService;

@RestController
@RequestMapping("/user")
public class ApiUserController {
    private final UserService userService;
    private final OauthService oauthService;

    @Autowired
    public ApiUserController(UserService userService, OauthService oauthService) {
        this.userService = userService;
        this.oauthService = oauthService;
    }

    @GetMapping("/login/oauth/github")
    public ApiResult loginUsingGithub(String code) {
        String accessToken = oauthService.getAccessToken(code);
        String email = oauthService.getEmail(accessToken);

        return ApiResult.succeed(userService.signIn(email, ResourceServer.GITHUB));
    }

    @GetMapping("/logined")
    public ApiResult isLoginValid() {
        return ApiResult.succeed("OK");
    }
}
