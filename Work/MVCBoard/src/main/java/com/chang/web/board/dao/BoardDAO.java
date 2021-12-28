package com.chang.web.board.dao;

import com.chang.web.board.model.BoardVO;

import java.util.List;


public interface BoardDAO {
	
	// 게시물 전체 출력
	public List<BoardVO> getBoardList() throws Exception;
	
	// 게시물 등록
	public int insertBoard(BoardVO boardVO) throws Exception;

	// 게시물 수정
	public int updateBoard(BoardVO boardVO) throws Exception;
	
	// 게시물 삭제
	public int deleteBoard(int postidx) throws Exception;
	
	// 조회수 증가
	public int updateViewCnt(int postidx) throws Exception;
	
}
