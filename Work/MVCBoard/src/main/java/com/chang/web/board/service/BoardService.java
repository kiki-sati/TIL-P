package com.chang.web.board.service;

import com.chang.web.board.model.BoardVO;

import java.util.List;

public interface BoardService {

    // 게시물 전체 출력
    public List<BoardVO> getBoardList()  throws Exception;
}
