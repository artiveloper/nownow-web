package kr.nownow.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "`POST`")
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "post_type")
    private String postType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private User writer;

    private String title;

    private String content;

    private int price;

    @Column(name = "image_path1")
    private String imagePath1;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "is_show")
    private boolean isShow;

}
