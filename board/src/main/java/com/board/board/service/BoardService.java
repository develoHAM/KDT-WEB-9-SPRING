package com.board.board.service;

import com.board.board.dto.BoardDTO;
import com.board.board.entity.BoardEntity;
import com.board.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시판 글 작성
    public boolean createPost(BoardDTO boardDTO) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(boardDTO.getTitle());
        boardEntity.setContent(boardDTO.getContent());
        boardEntity.setAuthor(boardDTO.getAuthor());
        boardRepository.save(boardEntity);
        return true;
    }

    public List<BoardDTO> findAllBoard() {
        List<BoardEntity> allBoard = boardRepository.findAll();
        List<BoardDTO> boards = new ArrayList<>();

        for(int i = 0; i < allBoard.size(); i++) {
            BoardDTO data = new BoardDTO();
            data.setId(allBoard.get(i).getId());
            data.setTitle(allBoard.get(i).getTitle());
            data.setContent(allBoard.get(i).getContent());
            data.setAuthor(allBoard.get(i).getAuthor());

            boards.add(data);
        }

        return boards;
     }

    public boolean updateBoard(BoardDTO boardDTO) {
        Optional<BoardEntity> board = boardRepository.findById(boardDTO.getId());
        if(board.isPresent()) {
            BoardEntity boardEntity = board.get();
            boardEntity.setTitle(boardDTO.getTitle());
            boardEntity.setContent(boardDTO.getContent());
            boardEntity.setAuthor(boardDTO.getAuthor());
            boardRepository.save(boardEntity);
            return true;
        } else {
            return false;
        }
    }

    public boolean deletePost(int id) {
        boardRepository.deleteById(id);
        return true;
    }
}
