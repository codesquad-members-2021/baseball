package codesquad.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Inning {

    @Id
    private Long id;

    private int out;
    private int inningNumber;
    private String role;
    private String cycle;

    public void update(int out) {
        this.out = out;
    }


}
