package com.lab0104.todaybackend.data.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@ToString
@Entity(name = "profile")
public class Profile extends BaseEntity{
    //Id column
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id", nullable = false)
    private long id;

    //Other columns
    @Column(name="background_image_url")
    private String backgroundUrl; //백그라운드 이미지

    @Column(name="profile_image_url")
    private String profileUrl; //프로필 이미지

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Profile(String backgroundUrl, String profileUrl, User user){
        this.backgroundUrl = backgroundUrl;
        this.profileUrl = profileUrl;
        this.user = user;
    }
}
