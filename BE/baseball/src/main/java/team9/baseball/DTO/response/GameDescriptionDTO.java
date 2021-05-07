package team9.baseball.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameDescriptionDTO {
    private Long id;
    private String awayTeam;
    private String homeTeam;
    private String awayUserEmail;
    private String homeUserEmail;
}
