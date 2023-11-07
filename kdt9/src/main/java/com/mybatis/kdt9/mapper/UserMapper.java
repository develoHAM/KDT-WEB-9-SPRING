package com.mybatis.kdt9.mapper;

import com.mybatis.kdt9.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // xml 파일을 참고해라. 즉 annotation 안씀
    List<User> retrieveAll();

    @Insert("INSERT INTO user (name, nickname) VALUES (#{name}, #{nickname})")
    void insertUser(User user);
}
