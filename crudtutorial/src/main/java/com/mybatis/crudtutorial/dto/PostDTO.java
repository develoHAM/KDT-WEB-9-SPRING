package com.mybatis.crudtutorial.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    public int id;
    public String title;
    public String content;
    public String writer;
    public LocalDateTime registered;
}
