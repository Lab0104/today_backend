package com.lab0104.todaybackend.data.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "banner_id")
    private Long id;

    @Column(name = "display_period" , nullable = false)
    private LocalDateTime display_period;

    @Column(name = "title")
    private String title;

    @Column(columnDefinition = "text")
    private String contents;

    @Column(name = "image_url")
    private Long image_url;

    @ManyToOne
    @JoinColumn(name = "meet_id")
    private Meet meet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Banner(LocalDateTime display_period, String title, String contents, long image_url,
                  Meet meet, User user) {
        this.display_period = display_period;
        this.title = title;
        this.contents = contents;
        this.image_url = image_url;
        this.meet = meet;
        this.user = user;
    }
}



