package com.mybatis.kdt9.repository;

import com.mybatis.kdt9.domain.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    List<BoardEntity> findByTitle(String word);
}
