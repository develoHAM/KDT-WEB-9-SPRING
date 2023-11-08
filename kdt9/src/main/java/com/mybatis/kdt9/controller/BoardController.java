package com.mybatis.kdt9.controller;

import com.mybatis.kdt9.domain.Board;
import com.mybatis.kdt9.dto.BoardDTO;
import com.mybatis.kdt9.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String getBoards(Model model) {
        List<BoardDTO> list = boardService.getBoardAll();
        model.addAttribute("list", list);
        return "board";
    }

    @GetMapping("/board/search")
    @ResponseBody
    public int searchBoard(@RequestParam String word) {
        return boardService.searchBoardByTitle(word);
    }

    @PostMapping("/board")
    @ResponseBody
    public void insertBoard(@RequestBody BoardDTO boardDTO) {
        boardService.insertBoard(boardDTO);
    }

    @PatchMapping("/board")
    @ResponseBody
    public void patchBoard(@RequestBody BoardDTO boardDTO) {
        boardService.patchBoard(boardDTO);
    }

    @DeleteMapping("/board")
    @ResponseBody
    public void deleteBoard(@RequestParam int id) {
        boardService.deleteBoard(id);
    }
}
