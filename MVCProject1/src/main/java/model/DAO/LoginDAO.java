package model.DAO;

import model.DTO.AuthInfo;

public class LoginDAO extends DataBaseInfo{
	public AuthInfo loginCk(String id , String pw) {
		AuthInfo authInfo = null;
		con = getConnection();
		String sql =" select emp_id, emp_pw, 'emp' grade from employees "
				+ "   where emp_id = ? "
				+ "   union "
				+ "   select mem_id, mem_pw, 'mem'  from member"
				+ "   where mem_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 아이디가 존재하면 AuthInfo 객체생성
				authInfo = new AuthInfo();
				authInfo.setGrade(rs.getString("grade"));
				authInfo.setUserId(rs.getString("emp_id"));
				authInfo.setUserPw(rs.getString("emp_pw"));
			} // if가 아니면 
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return authInfo;
	}
}



