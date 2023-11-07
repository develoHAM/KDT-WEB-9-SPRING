package com.mybatis.crudtutorial.controller;

import com.mybatis.crudtutorial.dto.PostDTO;
import com.mybatis.crudtutorial.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/posts")
    @ResponseBody
    public List<PostDTO> fetchPosts() {
        return postService.fetchPosts();
    }

    @GetMapping("/post")
    @ResponseBody
    public List<PostDTO> fetchPostsByWriter(@RequestParam String writer) {
        System.out.println("writer: " + writer);
        return postService.fetchPostsByWriter(writer);
    }

    @GetMapping("/post/{id}")
    @ResponseBody
    public PostDTO fetchPostById(@PathVariable int id) {
        return postService.fetchPostById(id);
    }

    @PostMapping("/post")
    @ResponseBody
    public boolean createPost(@RequestBody PostDTO postDTO) {
        return postService.createPost(postDTO);
    }

    @PutMapping("/post")
    @ResponseBody
    public boolean updatePost(@RequestBody PostDTO postDTO) {
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("/post/{id}")
    @ResponseBody
    public boolean deletePost(@PathVariable int id) {
        return postService.deletePost(id);
    }
}
