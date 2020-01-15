package kr.nownow.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String nickname;

}
