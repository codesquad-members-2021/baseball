package codesquad.baseball.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    @Id
    private Long id;

    private String name;

    private PlayerGameInfo playerGameInfo;
//    private List<History> histories;
}
