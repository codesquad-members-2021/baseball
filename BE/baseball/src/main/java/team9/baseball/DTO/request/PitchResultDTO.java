package team9.baseball.DTO.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team9.baseball.domain.enums.PitchResult;

@Getter
@Setter
@NoArgsConstructor
public class PitchResultDTO {
    private PitchResult pitchResult;
}
