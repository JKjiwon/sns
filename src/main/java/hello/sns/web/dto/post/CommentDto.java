package hello.sns.web.dto.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import hello.sns.domain.member.Member;
import hello.sns.domain.post.Comment;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    private Long id;

    private String content;

    private Long postId;

    private CommentWriterDto writer;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long parentId;

    private Integer countOfSubComments;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ChildCommentDto> subComments;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.postId = comment.getPost().getId();
        this.writer = new CommentWriterDto(comment.getWriter());
        this.parentId = comment.getParent() != null ? comment.getParent().getId() : null;
        this.countOfSubComments = comment.getChild().size();
        this.subComments = comment.getChild().stream()
                .map(ChildCommentDto::new)
                .collect(Collectors.toList());
        this.createdAt = comment.getCreatedAt();
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class ChildCommentDto {
        private Long id;

        private String content;

        private CommentWriterDto writer;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
        private LocalDateTime createdAt;

        public ChildCommentDto(Comment comment) {
            this.id = comment.getId();
            this.content = comment.getContent();
            this.writer = new CommentWriterDto(comment.getWriter());
            this.createdAt = comment.getCreatedAt();
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class CommentWriterDto {
        private Long id;
        private String name;

        public CommentWriterDto(Member member) {
            this.id = member.getId();
            this.name = member.getName();
        }
    }
}
