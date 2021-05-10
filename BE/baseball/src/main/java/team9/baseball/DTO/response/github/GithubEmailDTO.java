package team9.baseball.DTO.response.github;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubEmailDTO {
    private String email;
    private boolean primary;
    private boolean verified;
    private String visibility;
}
