package com.lab0104.todaybackend.data.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@ToString
@Entity(name = "user")
public class User extends BaseEntity{
    //Id column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private long id;

    //Other columns
    @Column(length = 45, nullable = false)
    private String email;

    @Column(length = 45, nullable = false)
    private String nickname;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String address;

    @Column(nullable = false)
    private float score;

    @Column(name = "login_method", length = 20, nullable = false)
    private String loginMethod;

    @Column(name = "password_key", length = 45, nullable = false)
    private String passwordKey;

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @Builder
    public User(String email, String nickname, String address, float score, String loginMethod, String passwordKey, String imageUrl){
        this.email = email;
        this.nickname = nickname;
        this.address = address;
        this.score = score;
        this.loginMethod = loginMethod;
        this.passwordKey = passwordKey;
        this.imageUrl = imageUrl;
    }

    public void setIdForUserUpdate(long id){
        this.id = id;
    }


}