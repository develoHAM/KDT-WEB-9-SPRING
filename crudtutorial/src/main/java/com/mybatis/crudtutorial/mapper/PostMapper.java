package com.mybatis.crudtutorial.mapper;

import com.mybatis.crudtutorial.domain.PostDomain;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDomain> fetchPosts();

    @Insert("INSERT INTO posts (title, content, writer) VALUES ( #{title}, #{content}, #{writer} )")
    int createPost(PostDomain post);

    @Select("SELECT * FROM posts WHERE writer = #{writer}")
    List<PostDomain> fetchPostsByWriter(String writer);

    @Update("UPDATE posts SET title = #{title}, content = #{content} WHERE id = #{id} ")
    int updatePost(PostDomain postDomain);

    @Delete("DELETE FROM posts WHERE id = #{id}")
    int deletePost(int id);

    @Select("SELECT * FROM posts WHERE id = #{id}")
    PostDomain fetchPostById(int id);
}
