package hello.sns.web.controller;

import hello.sns.web.CurrentUser;
import hello.sns.entity.member.Member;
import hello.sns.repository.MemberRepository;
import hello.sns.web.dto.member.MemberSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/me")
    @Secured("ROLE_USER")
    public MemberSummary getCurrentUser(@CurrentUser Member currentMember) {
        return new MemberSummary(currentMember.getId(), currentMember.getEmail(), currentMember.getName());
    }
}
