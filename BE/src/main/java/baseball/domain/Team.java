package baseball.domain;

import baseball.exception.MemberNotFoundException;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class Team {

    @Id
    private Long id;

    private String name;
    private Set<Member> members;
    private Set<Score> scores = new HashSet<>();

    public Team(String name, Set<Member> members) {
        this.name = name;
        if (!isMembersEmpty(members)) {
            this.members = members;
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    public Member getMemberById(Long id) {
        return members.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElseThrow(MemberNotFoundException::new);
    }

    public void deleteScores() {
        scores.clear();
    }

    private boolean isMembersEmpty(Set<Member> members) {
        if (!members.isEmpty()) {
            throw new MemberNotFoundException();
        }
        return false;
    }
}
