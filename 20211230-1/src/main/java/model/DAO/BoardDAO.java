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
	public BoardDAO() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() { // 데이터베이스에 접속
		Connection con =  null;
		try {
			// OracleDriver클래스 파일이 존재하는지 확인
			Class.forName(jdbcDriver);
			// 데이터베이스 접속정보
			con = DriverManager.getConnection(jdbcUrl,"kosa12","oracle");
		}catch(Exception e) {e.printStackTrace();}
		return con;
	}
	public void boardInsert(BoardDTO dto) {
		conn = getConnection();
		String sql = "insert into board(board_num,board_writer,board_subject,"
				+ "                  board_content, writer_ip )"
				+ "values(nvl((select max(board_num) from board  ), 0) + 1 ,"
				+ "?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getBoardWriter() );
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setString(4, dto.getWriterIp());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 행 이(가) 삽입되었습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
			if(conn != null) try{conn.close();}catch(Exception e) {}
		}
	}
}
