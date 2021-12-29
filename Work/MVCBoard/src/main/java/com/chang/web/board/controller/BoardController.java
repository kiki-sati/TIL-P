package com.chang.web.board.controller;

import com.chang.web.board.dao.BoardDAO;
import com.chang.web.board.model.BoardVO;
import com.chang.web.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 게시판 전체 출력
    @GetMapping("/board")
    public String getBoardList(Model model) throws Exception {
        model.addAttribute("boardList", boardService.getBoardList());
        return "board/list";
    }
    
    // 게시판 내용 출력
    @RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
    public String getBoardContent(Model model, @RequestParam("postIdx") int postIdx) throws Exception {
    	model.addAttribute("boardContent", boardService.getBoardContent(postIdx));
    	return "board/content";
    }

    // 게시글 작성
    @RequestMapping(value = "/board/write",method = RequestMethod.POST)
    public String write(BoardVO boardVO) throws Exception{
    	System.out.println("boardVO.getPostName() >> " + boardVO.getPostName());
    boardService.insertBoard(boardVO);
    return "redirect:/board"; // 컨트롤러 경로로 바로 넘겨준다.
    }

    // 글쓰기 버튼 클릭 시 호출
    @RequestMapping("/board/boardForm")
    public String call(){
        return "/board/boardForm";
        
    }
    
    // 게시글 수정
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String boardModify() throws Exception {
        return "redirect:/board";
    }


}
