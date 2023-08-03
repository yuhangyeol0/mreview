package com.example.mreview.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString(exclude = "movie") //연관관계주의
public class MovieImage extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inum;

    private String uuid;

    private String imgName;

    private String path;     //년/월/일 폴더 구조

    @ManyToOne(fetch = FetchType.LAZY) //FK를 가지게 됨
    private Movie movie;
}