package kr.nownow.dto;

import kr.nownow.domain.Post;
import kr.nownow.domain.Status;
import kr.nownow.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class PostDetailDto {

    private Long id;

    private String postType;

    private Long writerId;

    private String writer;

    private String title;

    private String content;

    private int price;

    private String originalPath;

    private String imagePath1;

    private Status status;

    private LocalDateTime createdDate;

    private boolean isShow;

    public PostDetailDto(Post post) {
        this.id = post.getId();
        this.postType = post.getPostType();
        this.writerId = post.getWriter().getId();
        this.writer = post.getWriter().getNickname();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.price = post.getPrice();
        this.originalPath = post.getImagePath1();
        this.imagePath1 = post.getImagePath1();
        this.status = post.getStatus();
        this.createdDate = post.getCreatedDate();
    }

    public String getImagePath1() {
        String[] split = this.imagePath1.split("/upload");
        return split[0] + "/upload/c_scale,h_300,w_300/" + split[1];
    }
}
