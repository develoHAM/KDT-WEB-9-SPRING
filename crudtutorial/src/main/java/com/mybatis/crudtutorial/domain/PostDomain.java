package com.mybatis.crudtutorial.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDomain {
    public int id;
    public String title;
    public String content;
    public String writer;
    public LocalDateTime registered;
}
