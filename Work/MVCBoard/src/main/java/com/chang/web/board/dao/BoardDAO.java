package com.chang.web.board.dao;

import com.chang.web.board.model.BoardVO;

import java.util.List;


public interface BoardDAO {
	
	// 게시물 전체 출력
	public List<BoardVO> getBoardList() throws Exception;
	
	// 게시물 등록
	public void insertBoard(BoardVO boardVO) throws Exception;

	// 게시물 수정
	public int updateBoard(BoardVO boardVO) throws Exception;
	
	// 게시물 삭제
	public int deleteBoard(int postIdx) throws Exception;
	
	// 조회수 증가
	public int updateViewCnt(int postIdx) throws Exception;
	
	// 게시물 상세 페이지
	public BoardVO getBoardContent(int postIdx) throws Exception;
	
}
