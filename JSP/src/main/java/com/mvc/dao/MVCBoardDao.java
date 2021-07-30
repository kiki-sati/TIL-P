
package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;
import com.mvc.util.JdbcUtil;

public class MVCBoardDao {
	
	// 외부 인스턴스화 막기.
	private static MVCBoardDao dao = new MVCBoardDao();
	
	public static MVCBoardDao getInstance() {
		return dao;
		
	}
	
	// 게시글 전체 출력
	public List<MVCBoardDto> selectAll(Connection conn, int firstRow, int messageCountPerPage) throws SQLException{
		
		//DB 연결
		List<MVCBoardDto> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from mvcboard";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, messageCountPerPage);
			
			rs = pstmt.executeQuery(sql);
			
			list = new ArrayList<MVCBoardDto>();
			while(rs.next()) {
				
				list.add(new MVCBoardDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getTimestamp(5)));
						
			}
			
			
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			
		}
		return list;
		}
		
	
	// 게시글 하나 출력
	public MVCBoardDto selectOne(int bdno) {
		
	}
	
	// 글쓰기
	
	// 글 수정
	
	// 글삭제 
	
	// 글여러개 삭제 (멀티삭제)

}
