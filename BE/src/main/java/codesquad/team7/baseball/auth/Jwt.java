package codesquad.team7.baseball.auth;

public class Jwt {
    private final String jwt;

    public Jwt(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}

