package com.example.jpapractice.jpaboardcrud.repository;

import com.example.jpapractice.jpaboardcrud.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
