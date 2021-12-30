package com.chang.web.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chang.web.board.model.BoardVO;
import com.chang.web.board.model.CommentVO;
import com.chang.web.board.service.BoardService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 게시판 전체 출력
	@GetMapping("/list")
	public String getBoardList(Model model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}

	// 게시글 내용 출력
	@RequestMapping(value = "/getBoardContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("postIdx") int postIdx) throws Exception {
		boardService.updateViewCnt(postIdx);
		model.addAttribute("boardContent", boardService.getBoardContent(postIdx));

		// 댓글 출력
		List<CommentVO> commList = boardService.getCommentList(postIdx);
		model.addAttribute("commList", commList);

		return "board/content";
	}

	// 글쓰기 버튼 클릭 시 호출
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String getWrite() throws Exception {
		return "/board/write";
	}

	// 게시글 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String boardWrite(BoardVO boardVO) throws Exception {
		System.out.println("boardVO.getPostName() >> " + boardVO.getPostName());
		boardService.insertBoard(boardVO);
		return "redirect:/board/list"; // 컨트롤러 경로로 바로 넘겨준다.
	}

	// 게시글 수정 내용 출력
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String boardUpdate(Model model, @RequestParam("postIdx") int postIdx) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardContent(postIdx));
		return "board/modify";
	}

	// 게시글 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String boardModify(BoardVO boardVO) throws Exception {
		boardService.updateBoard(boardVO);
		return "redirect:/board/getBoardContent?postIdx=" + boardVO.getPostIdx();
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("postIdx") int postIdx) throws Exception {
		boardService.deleteBoard(postIdx);
		return "redirect:/board";
	}

	// 댓글 등록
	@RequestMapping("/insertComm")
	@ResponseBody
	public int insertComment(@ModelAttribute CommentVO commentVO) {
		int result = 0;

		System.out.println("commentVO >> " + commentVO.getCmContent());
		try {
			result = boardService.insertComment(commentVO);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		return result;
	}

	// 댓글 리스트 ajax
	@RequestMapping(value = "/selectCommList", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectReplyList(int postIdx, Model model) throws Exception {

		// ajax에서 에러를 처리해줌으로throws Exception
		// try catch를 안해줘도됨(다른방법도 있음)
		List<CommentVO> commList = boardService.getCommentList(postIdx);

		model.addAttribute("commCount", commList.size());

		// JSON으로 담아도 되지만 편한 방법인 GSON으로 사용

		// yyyy-MM-dd hh:mm:ss
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm").create();

		return gson.toJson(commList);
	}

}
