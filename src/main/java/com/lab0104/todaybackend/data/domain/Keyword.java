package com.lab0104.todaybackend.data.domain;

import lombok.*;

import javax.persistence.*;
@Entity(name = "KEYWORD")
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Getter
@Setter
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private Long id;

    @Column(name = "keyword")
    private String keyword;

    @Builder
    public Keyword(Long id, String keyword) {
        this.id = id;
        this.keyword = keyword;
    }

    public void setIdForUpdate(Long id) {
        this.id = id;
    }
}
