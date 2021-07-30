
package com.mvc.dto;

import java.sql.Timestamp;

//Bean 생성 - DTO 데이터 전송 객체
//데이터가 포함된 객체를 한 시스템에서 다른 시스템으로 전달하는 작업을 처리하는 객체

public class MVCBoardDto {
	
	private int bdno;
	private String bdname;
	private String bdtitle;
	private String bdcontent;
	private Timestamp bddate;
	
	public MVCBoardDto () {};
	
	// 생성자 
	public MVCBoardDto(int bdno, String bdname, String bdtitle, String bdcontent, Timestamp bddate) {
		super();
		this.bdno = bdno;
		this.bdname = bdname;
		this.bdtitle = bdtitle;
		this.bdcontent = bdcontent;
		this.bddate = bddate;
	}

	public int getBdno() {
		return bdno;
	}

	public void setBdno(int bdno) {
		this.bdno = bdno;
	}

	public String getBdname() {
		return bdname;
	}

	public void setBdname(String bdname) {
		this.bdname = bdname;
	}

	public String getBdtitle() {
		return bdtitle;
	}

	public void setBdtitle(String bdtitle) {
		this.bdtitle = bdtitle;
	}

	public String getBdcontent() {
		return bdcontent;
	}

	public void setBdcontent(String bdcontent) {
		this.bdcontent = bdcontent;
	}

	public Timestamp getBddate() {
		return bddate;
	}

	public void setBddate(Timestamp bddate) {
		this.bddate = bddate;
	}

	@Override
	public String toString() {
		return "MVCBoardDto [bdno=" + bdno + ", bdname=" + bdname + ", bdtitle=" + bdtitle + ", bdcontent=" + bdcontent
				+ ", bddate=" + bddate + "]";
	}
	
	
	
	
	
	
	
	

}
