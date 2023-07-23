package com.lab0104.todaybackend.data.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@ToString(exclude = "...")
@Entity(name = "category")
public class Category extends BaseEntity {
    //Id column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    //Other columns
    @Column(name = "category_name", length = 20, nullable = false)
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "depth")
    private Integer depth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="high_category_id")
    private Category categoryGroup; //자기참조

    @Builder
    public Category(String name, String imageUrl, Category categoryGroup){
        this.name = name;
        this.imageUrl = imageUrl;
        this.categoryGroup = categoryGroup;
    }

    @Builder
    public Category(String name, String imageUrl, Integer depth) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.depth = depth;
    }
    private void setDepth(Integer depth) {
        this.depth = depth;
    }


    @Builder
    public void setIdForCategoryUpdate(long id){
        this.id = id;
    }

}