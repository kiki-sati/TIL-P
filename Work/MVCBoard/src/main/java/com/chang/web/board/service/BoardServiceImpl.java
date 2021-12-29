package com.chang.web.board.service;

import com.chang.web.board.dao.BoardDAO;
import com.chang.web.board.model.BoardVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
        dao = template.getMapper(BoardDAO.class);
        dao.insertBoard(boardVO);
    }

    @Override
    public int updateBoard(BoardVO boardVO) throws Exception {
        dao = template.getMapper(BoardDAO.class);
        return dao.updateBoard(boardVO);
    }
}
