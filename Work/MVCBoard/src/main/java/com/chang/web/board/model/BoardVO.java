package com.chang.web.board.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	
	private int postIdx;
	private String postName;
	private String postContent;
	private String postWriter;
	private String postDate;
	private String editDate;
	private int postView;
	private String bdCategory;
	private String password;

	/*
	 * 계층형 게시판을 위한 추가 필드
	 * groupNo, groupOrd, groupLayer
	 */
	
	// 그룹Index - 원글의 Idx값
	private int groupNo;
	
	// 원글(답글포함)에 대한 순서 - 원래데이터 +1
	private int groupOrd;
	
	// 답글 계층 - 원래데이터 + 1
	private int groupLayer;
	

}


