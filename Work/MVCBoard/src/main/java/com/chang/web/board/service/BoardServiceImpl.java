package com.chang.web.board.service;

import com.chang.web.board.dao.BoardDAO;
import com.chang.web.board.model.BoardVO;
import com.chang.web.board.service.BoardService;

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
}
