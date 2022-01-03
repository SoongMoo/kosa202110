package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.BoardDTO;

public class BoardDAO extends DataBaseInfo {

	public void visitCount(String num) {
		con = getConnection();

		String sql = " update board "
				+ "    set visit_count = visit_count + 1 "
				+ "    where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();		
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
			if(con != null) try{con.close();}catch(Exception e) {}
		}
	}
	public void boardUpdate(BoardDTO dto) {
		con = getConnection();
		String sql = "update board"
				+ " set BOARD_WRITER = ? , BOARD_SUBJECT = ?, "
				+ "     BOARD_CONTENT = ? "
				+ " where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setInt(4, dto.getBoardNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();			
		}finally {
			if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
			if(con != null) try{con.close();}catch(Exception e) {}
		}
	}
	public void boardDel(String num) {
		con = getConnection();
		String sql = "delete from board where board_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i +" 개 행이(가) 삭제되었습니다.");
		}catch(Exception e) {e.printStackTrace();
		} finally {
			if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
			if(con != null) try{con.close();}catch(Exception e) {}
		}
	}
	public BoardDTO selectOne(String num) {
		BoardDTO dto = new BoardDTO();
		con = getConnection(); // con = conn;
		String sql = "select BOARD_NUM, BOARD_WRITER, BOARD_SUBJECT, "
				+ " BOARD_CONTENT, WRITER_IP, VISIT_COUNT"
				+ " from board "
				+ " where BOARD_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setBoardContent(rs.getString("BOARD_CONTENT"));
				dto.setBoardNum(rs.getInt("BOARD_NUM"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardWriter(rs.getString("BOARD_WRITER"));
				dto.setVisitCount(rs.getInt("VISIT_COUNT"));
				dto.setWriterIp(rs.getString("WRITER_IP"));
			}
			System.out.println(dto.getBoardContent());
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rs != null) try{rs.close();}catch(Exception e) {}
			if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
			if(con != null) try{con.close();}catch(Exception e) {}
		}
		return dto;
	}
	public List<BoardDTO> selectAll(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		con = getConnection();
		String sql = "select BOARD_NUM, BOARD_WRITER, BOARD_SUBJECT, "
				+ " BOARD_CONTENT, WRITER_IP, VISIT_COUNT"
				+ " from board "
				+ " order by board_num desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			                   // rs.next()할 때마다 커서가 한 행씩 이동한다.
			while(rs.next()) { //EOF를 만나면 더 이상 반복하지 않는다.
				BoardDTO dto = new BoardDTO();
				dto.setBoardContent(rs.getString("BOARD_CONTENT"));
				dto.setBoardNum(rs.getInt("BOARD_NUM"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardWriter(rs.getString("BOARD_WRITER"));
				dto.setVisitCount(rs.getInt("VISIT_COUNT"));
				dto.setWriterIp(rs.getString("WRITER_IP"));
				list.add(dto);
			}
			System.out.println("인출된 모든 행 : " +list.size());
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rs != null) try{rs.close();}catch(Exception e) {}
			if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
			if(con != null) try{con.close();}catch(Exception e) {}
		}
		return list;
	}
	public void boardInsert(BoardDTO dto) {
		con = getConnection();
		String sql = " insert into board(BOARD_NUM,BOARD_WRITER,BOARD_SUBJECT,"
				+ " BOARD_CONTENT, WRITER_IP)"
				+ " values((select nvl(max(board_num),0)+1 from board)"
				+ " ,?,?,?,?)";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setString(4, dto.getWriterIp());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개 행이(가) 삽입되었습니다.");
		} catch (SQLException e) {e.printStackTrace();
		} finally {
			if(pstmt != null) try{pstmt.close();}catch(Exception e){};
			if(con != null) try{con.close();}catch(Exception e){};
		}
	}	
}