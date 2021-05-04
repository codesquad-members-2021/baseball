package codesquad.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class History {
    @Id
    private Long id;
    private String actionName;
    private int strike;
    private int ball;
    private int out;

}
