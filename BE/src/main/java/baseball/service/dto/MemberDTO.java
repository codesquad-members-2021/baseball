package baseball.service.dto;

import baseball.domain.Member;

public class MemberDTO {

    private Long id;
    private String name;
    private String position;

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.position = member.getPosition();
    }

    public static MemberDTO toMemberDTO(Member member) {
        return new MemberDTO(member);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }
}
