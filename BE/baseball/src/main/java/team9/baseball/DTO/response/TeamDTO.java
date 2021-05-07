package team9.baseball.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamDTO {
    private String name;
    private int score;
    private String role;

    public static TeamDTO of(String name, int score, String role) {
        return builder()
                .name(name)
                .score(score)
                .role(role)
                .build();
    }
}
