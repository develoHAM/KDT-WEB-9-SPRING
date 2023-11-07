package com.example.jpapractice.jpaboardcrud.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PostDTO {
    private long id;
    private String title;
    private String content;
    private Date dateCreated;
    private Date lastUpdated;
}
