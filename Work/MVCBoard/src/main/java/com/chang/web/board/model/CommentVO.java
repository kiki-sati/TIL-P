package com.chang.web.board.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class CommentVO {
	
	private String cmIdx;
	private String cmContent;
	private String cmDate;
	private String cmWriter;
	private int postIdx;

}


