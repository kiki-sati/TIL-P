package com.chang.web.board.dao;

import com.chang.web.board.model.BoardVO;
import com.chang.web.board.model.CommentVO;

import java.util.List;
import java.util.Map;


public interface BoardDAO {
	
	// 게시물 전체 출력
	public List<BoardVO> getBoardList() throws Exception;
	
	// 게시물 등록
	public void insertBoard(BoardVO boardVO) throws Exception;

	// 답글 등록
	public void insertBoardReply(BoardVO boardVO) throws Exception;

	// 게시물 수정
	public int updateBoard(BoardVO boardVO) throws Exception;
	
	// 게시물 삭제
	public void deleteBoard(int postIdx) throws Exception;
	
	// 조회수 증가
	public void updateViewCnt(int postIdx) throws Exception;
	
	// 게시물 상세 페이지
	public BoardVO getBoardContent(int postIdx) throws Exception;
	
	// 댓글 리스트 출력
	List<CommentVO> getCommentList(int postIdx) throws Exception;
	
	// 댓글 입력
	Integer insertComment(CommentVO commentVO) throws Exception;

	
}
