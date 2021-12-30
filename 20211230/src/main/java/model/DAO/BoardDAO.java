package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.DTO.BoardDTO;

public class BoardDAO {
	String jdbcDriver;
	String jdbcUrl;
	Connection conn;
	PreparedStatement pstmt;
	public BoardDAO(){
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcUrl,"kosa12","oracle");
		}catch(Exception e) {e.printStackTrace();}
		return con;
	}
	public void boardInsert(BoardDTO dto) {
		conn = getConnection();
		String sql = "insert into board(board_num, board_writer,board_subject, "
				+ "board_content, writer_ip)"
				+ "values((select nvl(max(board_num),0)+ 1 from board),"
				+ "?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setString(4, dto.getWriterIp());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개 행이(가) 삽입되었습니다.");
		}catch(Exception e) {e.printStackTrace(); }
		finally {
			if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
			if(conn != null) try{conn.close();}catch(Exception e) {}
		}
		
	}
}





