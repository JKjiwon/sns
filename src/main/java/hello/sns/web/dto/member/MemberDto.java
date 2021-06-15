package hello.sns.web.dto.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import hello.sns.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MemberDto {

    private Long id;

    private String email;

    private String name;

    private String profileImagePath;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime joinedAt;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.name = member.getName();
        this.profileImagePath = member.getProfileImagePath();
        this.joinedAt = member.getCreatedAt();
    }
}