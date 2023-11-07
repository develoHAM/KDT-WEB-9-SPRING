package com.example.jpapractice.jpaboardcrud.service;

import com.example.jpapractice.jpaboardcrud.entities.PostEntity;
import com.example.jpapractice.jpaboardcrud.dto.PostDTO;
import com.example.jpapractice.jpaboardcrud.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getPosts() {
        List<PostEntity> posts = postRepository.findAll();
        List<PostDTO> postDTOS = new ArrayList<PostDTO>();
        return postDTOS;
    }

    public void uploadPost(PostDTO postDTO) {
        PostEntity post = new PostEntity();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        postRepository.save(post);
    }
}
