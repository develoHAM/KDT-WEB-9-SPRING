package com.board.board.controller;

import com.board.board.dto.BoardDTO;
import com.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 글 작성
    @PostMapping("/register")
    @ResponseBody
    public boolean createPost(@RequestBody BoardDTO boardDTO) {
        return boardService.createPost(boardDTO);
    }

    @GetMapping("/all")
    public List<BoardDTO> getAllBoard() {
        return boardService.findAllBoard();
    }

    @PatchMapping("/update")
    @ResponseBody
    public boolean patchUpdate(@RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(boardDTO);
        return true;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deletePost(@PathVariable int id) {
        return boardService.deletePost(id);
    }

}
