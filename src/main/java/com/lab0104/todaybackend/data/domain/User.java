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

    @Column(name = "address_latitude", nullable = true)
    private double addressLatitude;

    @Column(name = "address_longitude", nullable = true)
    private double addressLongitude;

    @Column(nullable = false)
    private float score;

    @Column(name = "login_method", length = 20, nullable = false)
    private String loginMethod;

    @Column(name = "password_key", length = 45, nullable = false)
    private String passwordKey;

    @Builder
    public User(String email, String nickname, String address,
                double addressLatitude, double addressLongitude, float score, String loginMethod, String passwordKey){
        this.email = email;
        this.nickname = nickname;
        this.address = address;
        this.addressLatitude = addressLatitude;
        this.addressLongitude = addressLongitude;
        this.score = score;
        this.loginMethod = loginMethod;
        this.passwordKey = passwordKey;
    }

    public void setIdForUserUpdate(long id){
        this.id = id;
    }


}