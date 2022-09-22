//작성일 : 2021. 8. 1.
//DAO DB에서 회원 정보를 불러오거나 넣기 위한 기능
package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	
	//객체접근 
	private Connection conn;
	private PreparedStatement pstmt;
	//정보를 담을 수 있는 객체 
	private ResultSet rs;
	
	public UserDAO() {
		//MYSQL 접속
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
			String user = "test";
			String pw = "1111";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
		} catch (Exception e) {
			e.printStackTrace(); //오류가 무엇인지 출력 
		}
	}
	
	//로그인 부분 
	public int login(String userID, String userPassword) {
		String SQL = "select userPassword from user where userID = ?";
		try {
			pstmt = conn.prepareStatement(SQL); //
			pstmt.setString(1, userID); // 물음표에 들어갈 수 있게 해주는 부분. 
			rs = pstmt.executeQuery(); // 결과를 담을 수 있는 객체에 실행한 결과를 넣어준다. 
			
			if (rs.next()) { //결과가 존재하면 실행되는 부분 
				if (rs.getString(1).equals(userPassword)) {
					return 1; //로그인 성공
				} else {
					return 0; //비밀번호 불일치
				}
			
				
			}	
			return -1;	//아이디가 없음 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터베이스 오류 
	}

}
