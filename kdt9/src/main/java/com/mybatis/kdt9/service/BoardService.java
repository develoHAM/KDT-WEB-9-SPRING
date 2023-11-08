package com.mybatis.kdt9.service;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.domain.BoardEntity;
import com.mybatis.kdt9.dto.BoardDTO;
import com.mybatis.kdt9.mapper.BoardMapper;
import com.mybatis.kdt9.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;
    // 1. 전체 조회 List<BoardDTO>
    public List<BoardDTO> getBoardAll() {
//        List<Board> result = boardMapper.getBoardAll();
        List<BoardEntity> result = boardRepository.findAll();
        List<BoardDTO> list = new ArrayList<>();

        for (BoardEntity board : result ) {
            BoardDTO boardDTO = BoardDTO.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .content(board.getContent())
                    .createdAt(board.getCreatedAt())
                    .no(board.getWriter() + board.getId())
                    .build();
            list.add(boardDTO);
        }

        return list;
    }

    public void insertBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .content(boardDTO.getContent())
                .build();
        boardRepository.save(boardEntity);
//        boardMapper.insertBoard(board);

    }

    public void patchBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.builder()
                .title(boardDTO.getTitle())
                .writer(boardDTO.getWriter())
                .content(boardDTO.getContent())
                .build();
        boardRepository.save(boardEntity);
//        boardMapper.patchBoard(boardDTO);
        // mapper 파일에서는 여러 개를 parameter로 받을 수 있는데
        // xml 파일은 하나밖에 못받는다
    }

    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
//        boardMapper.deleteBoard(id);
    }

    public int searchBoardByTitle(String word) {
//        List<Board> result = boardMapper.searchBoardByTitle(word);
        List<BoardEntity> result = boardRepository.findByTitle(word);
        return result.size();
    }
}
