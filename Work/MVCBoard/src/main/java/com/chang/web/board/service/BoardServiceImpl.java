package com.chang.web.board.service;

import com.chang.web.board.dao.BoardDAO;
import com.chang.web.board.model.BoardVO;
import com.chang.web.board.model.CommentVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    private BoardDAO dao;

    @Autowired
    private SqlSessionTemplate template;

    //게시물 전체 출력
    @Override
    public List<BoardVO> getBoardList() throws Exception {
    	dao = template.getMapper(BoardDAO.class);
        return dao.getBoardList();
    }

    // 게시물 내용 출력
	@Override
	public BoardVO getBoardContent(int postIdx) throws Exception {
		dao = template.getMapper(BoardDAO.class);
		return dao.getBoardContent(postIdx);
	}

	// 게시글 작성
    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
        dao = template.getMapper(BoardDAO.class);
        dao.insertBoard(boardVO);
    }

    // 게시글 수정
    @Override
    public void updateBoard(BoardVO boardVO) throws Exception {
        dao = template.getMapper(BoardDAO.class);
        dao.updateBoard(boardVO);
    }

    // 게시물 삭제
	@Override
	public void deleteBoard(int postIdx) throws Exception {
		dao = template.getMapper(BoardDAO.class);
		dao.deleteBoard(postIdx);
		
	}
	
	// 조회수 증가
	@Override
	public void updateViewCnt(int postIdx) throws Exception {
		dao = template.getMapper(BoardDAO.class);
		dao.updateViewCnt(postIdx);
		
	}

	// 댓글 전체 출력
	@Override
	public List<CommentVO> getCommentList(int postIdx) throws Exception {
		dao = template.getMapper(BoardDAO.class);
		return dao.getCommentList(postIdx);
	}

	// 댓글 입력
	@Override
	public Integer insertComment(CommentVO commentVO) throws Exception {
		dao = template.getMapper(BoardDAO.class);
		return dao.insertComment(commentVO);
	}
}
