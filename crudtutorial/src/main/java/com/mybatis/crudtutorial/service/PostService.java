package com.mybatis.crudtutorial.service;

import com.mybatis.crudtutorial.domain.PostDomain;
import com.mybatis.crudtutorial.dto.PostDTO;
import com.mybatis.crudtutorial.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<PostDTO> fetchPosts() {
        List<PostDomain> result = postMapper.fetchPosts();
        List<PostDTO> posts = new ArrayList<>();
        for(int i = 0; i < result.size(); i++) {
            PostDomain resultPost = result.get(i);
            PostDTO post = PostDTO.builder()
                    .id(resultPost.getId())
                    .title(resultPost.getTitle())
                    .writer(resultPost.getWriter())
                    .content(resultPost.getContent())
                    .registered(resultPost.getRegistered())
                    .build();
            posts.add(post);
        }
        return posts;
    }


    public boolean createPost(PostDTO postDTO) {
        PostDomain post = PostDomain.builder()
                .title(postDTO.getTitle())
                .writer(postDTO.getWriter())
                .content(postDTO.getContent())
                .build();

        int result = postMapper.createPost(post);

        if(result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<PostDTO> fetchPostsByWriter(String writer) {
        List<PostDomain> result = postMapper.fetchPostsByWriter(writer);
        List<PostDTO> posts = new ArrayList<>();
        for(int i = 0; i < result.size(); i++) {
            PostDomain resultPost = result.get(i);
            PostDTO post = PostDTO.builder()
                    .id(resultPost.getId())
                    .title(resultPost.getTitle())
                    .writer(resultPost.getWriter())
                    .content(resultPost.getContent())
                    .registered(resultPost.getRegistered())
                    .build();
            posts.add(post);
        }
        return posts;
    }

    public boolean updatePost(PostDTO postDTO) {
        PostDomain postDomain = PostDomain.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .content(postDTO.getTitle())
                .build();
        int result = postMapper.updatePost(postDomain);
        if(result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePost(int id) {
        int result = postMapper.deletePost(id);

        if(result == 1) {
            return true;
        } else {
            return false;
        }    }

    public PostDTO fetchPostById(int id) {
        PostDomain result = postMapper.fetchPostById(id);
        PostDTO post = PostDTO.builder()
                .id(result.getId())
                .title(result.getTitle())
                .writer(result.getWriter())
                .content(result.getContent())
                .registered(result.getRegistered())
                .build();
        return post;
    }
}
