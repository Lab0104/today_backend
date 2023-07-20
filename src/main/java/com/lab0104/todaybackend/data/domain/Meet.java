package com.lab0104.todaybackend.data.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@ToString(exclude = "...")
@Entity(name = "meet")
public class Meet extends BaseEntity{
    //Id column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meet_id")
    private long id;

    //Other columns
    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(name = "sub_title", length = 45)
    private String subTitle;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 6, nullable = false)
    private LocalDateTime date;

    @Column(length = 6, nullable = false)
    private LocalDateTime deadline;

    @Column(name = "maximum_participants", nullable = false)
    private int maximum;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "address_latitude")
    private double addressLatitude;

    @Column(name = "address_longitude")
    private double addressLongitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    @NonNull
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NonNull
    private User user;

    @Builder
    public Meet(String title, String subTitle, String content, LocalDateTime date, LocalDateTime deadline,
                        int maximum, String address, double addressLatitude, double addressLongitude, Category category, User user){
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.date = date;
        this.deadline = deadline;
        this.maximum = maximum;
        this.address = address;
        this.addressLatitude = addressLatitude;
        this.addressLongitude = addressLongitude;
        this.category = category;
        this.user = user;
    }

    @Builder
    public void setMeetIdForUpdate(long id){
        this.id = id;
    }
}