package com.mybatis.kdt9.mapper;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoardAll(); // 전체 조회

    void insertBoard(Board board); // 삽입 (insert)

    void patchBoard(BoardDTO boardDTO); // 수정 (update)

    void deleteBoard(int id);

    List<Board> searchBoardByTitle(String word);
}
