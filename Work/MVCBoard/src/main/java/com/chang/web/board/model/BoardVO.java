package com.chang.web.board.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class BoardVO {
	
	private int postIdx;
	private String postName;
	private String postContent;
	private String postWriter;
	private String postDate;
	private String editDate;
	private int postView;
	private String bdCategory;
	

}


