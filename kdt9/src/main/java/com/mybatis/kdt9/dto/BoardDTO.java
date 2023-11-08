package com.mybatis.kdt9.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private String registered;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String no;
}
