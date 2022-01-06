package model.DAO;

public class LoginDAO extends DataBaseInfo{
	public int loginCk(String id , String pw) {
		int i = 0;
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
			if (rs.next()) { // 아이디가 존재
				if(pw.equals(rs.getString("emp_pw"))) {
					i = 1; //아이디와 비밀번호가 일치함
				}else {
					i = 0; // 아이디 존재하지만 비밀번호가 틀림
				}
			}else { // 아이디가 존재하지 않는다.
				i = -1; // 해당 id가 존재하지 않음.
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		
		return i;
		
	}
}



