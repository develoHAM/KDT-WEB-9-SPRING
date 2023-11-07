package com.example.jpapractice.jpaboardcrud.controller;

import com.example.jpapractice.jpaboardcrud.dto.PostDTO;
import com.example.jpapractice.jpaboardcrud.entities.PostEntity;
import com.example.jpapractice.jpaboardcrud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String getMain() {
        return "posts";
    }

    @GetMapping("/posts")
    @ResponseBody
    public List<PostDTO> getPosts() {
        List<PostDTO> posts = postService.getPosts();
        return posts;
    }

    @PostMapping("/post")
    @ResponseBody
    public void submitPost(@RequestBody PostDTO postDTO) {
        postService.uploadPost(postDTO);
    }
}
