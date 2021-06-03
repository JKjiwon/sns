package hello.sns.web.controller;

import hello.sns.entity.member.Member;
import hello.sns.service.CommunityServiceImpl;
import hello.sns.web.dto.common.CurrentMember;
import hello.sns.web.dto.community.CreateCommunityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/communities")
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityServiceImpl communityService;

    @PostMapping
    public ResponseEntity createCommunity(
            @Validated CreateCommunityDto createCommunityDto,
            @RequestPart(value = "mainImage", required = false) MultipartFile mainImage,
            @RequestPart(value = "thumbNailImage", required = false) MultipartFile thumbNailImage,
            @CurrentMember Member currentMember) {

        communityService.create(createCommunityDto, mainImage, thumbNailImage, currentMember);

        return ResponseEntity.ok("ok");
    }
}