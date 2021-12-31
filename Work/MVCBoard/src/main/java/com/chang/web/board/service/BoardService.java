package com.chang.web.board.service;

import com.chang.web.board.model.BoardVO;
import com.chang.web.board.model.CommentVO;

import java.util.List;
import java.util.Map;

public interface BoardService {

	// 게시물 전체 출력
	public List<BoardVO> getBoardList() throws Exception;

	// 게시물 내용 출력
	public BoardVO getBoardContent(int postIdx) throws Exception;

	// 게시글 작성 (void 하면 리턴 안해도 된다.)
	public void insertBoard(BoardVO boardVO) throws Exception;

	// 답글 등록
	public void insertBoardReply(BoardVO boardVO) throws Exception;

	// 게시물 수정
	public void updateBoard(BoardVO boardVO) throws Exception;

	// 게시물 삭제
	public void deleteBoard(int postIdx) throws Exception;

	// 조회수 증가
	public void updateViewCnt(int postIdx) throws Exception;
	
	// 댓글 리스트 출력
	List<CommentVO> getCommentList(int postIdx) throws Exception;
	
	// 댓글 입력
	Integer insertComment(CommentVO commentVO) throws Exception;
}
