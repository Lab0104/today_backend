package com.lab0104.todaybackend.data.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@ToString(exclude = "...")
@Entity(name = "member")
public class Member {

    //Id column
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    private String status;

    //Other columns
    @ManyToOne
    @JoinColumn(name = "meet_id")
    private Meet meet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Member(Meet meet, User user){
        this.meet = meet;
        this.user = user;
        if (meet.getUser().getId() == user.getId()){
            setStatus("주최자");
        } else { setStatus("참여자"); }
    }

    private void setStatus(String status){ this.status = status;}
}
