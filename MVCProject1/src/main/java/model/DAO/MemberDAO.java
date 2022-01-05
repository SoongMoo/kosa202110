package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.MemberDTO;

public class MemberDAO extends DataBaseInfo{
	final String COLUMNS = "MEM_NUM,MEM_NAME,MEM_REGI_DATE,"
			+ "MEM_ID, MEM_PW,MEM_PHONE1, MEM_PHONE2,MEM_ADDR,"
			+ "MEM_EMAIL,MEM_GENDER,MEM_birth ";
	public void memberPassUpdate(String memId, String memPw) {
		con = getConnection();
		String sql = " update member "
				+ "    set mem_pw = ?"
				+ "    where mem_id  = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memPw);
			pstmt.setString(2, memId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public void memberMyUpdate(MemberDTO dto) {
		con = getConnection();
		String sql = " update member "
				+ " set MEM_NAME = ?, MEM_PHONE1 = ?,  "
				+ "     MEM_PHONE2 = ? , MEM_ADDR = ? ,"
				+ "     MEM_EMAIL = ? , MEM_GENDER = ?, "
				+ "     MEM_birth =? "
				+ " where MEM_ID = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName());
			pstmt.setString(2, dto.getMemPhone1());
			pstmt.setString(3, dto.getMemPhone2());
			pstmt.setString(4, dto.getMemAddr());
			pstmt.setString(5, dto.getMemEmail());
			pstmt.setString(6, dto.getMemGender());
			pstmt.setTimestamp(7, dto.getMemBirth());
			pstmt.setString(8, dto.getMemId());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개 행이(가) 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		
	}
	public MemberDTO selectUser(String memId) {
		MemberDTO dto = new MemberDTO();
		con = getConnection();
		String sql = "select " + COLUMNS + " from member "
				+ " where MEM_ID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(
						new java.util.Date(
								rs.getDate("mem_regi_date").getTime()));
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return dto;
	}
	public void memberJoin(MemberDTO dto) {
		con = getConnection();
		String sql = "insert into member ( " + COLUMNS + ") "
				+ " values(("
				+ " select concat('kosa', nvl(max(substr(mem_num,5)),100000) + 1)  from member"
				+ " ),?,sysdate,?,?,?,?,?,?,?,?) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName());
			pstmt.setString(2, dto.getMemId());
			pstmt.setString(3, dto.getMemPw());
			pstmt.setString(4, dto.getMemPhone1());
			pstmt.setString(5, dto.getMemPhone2());
			pstmt.setString(6, dto.getMemAddr());
			pstmt.setString(7, dto.getMemEmail());
			pstmt.setString(8, dto.getMemGender());
			pstmt.setTimestamp(9, dto.getMemBirth());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개 행이(가) 삽입되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public void memberUpdate(MemberDTO dto) {
		con = getConnection();
		String sql = " update member "
				+ "    set MEM_NAME = ?, MEM_PHONE1 = ?, "
				+ "        MEM_PHONE2 = ?, MEM_ADDR =? ,"
				+ "        MEM_EMAIL =?, MEM_GENDER =? ,"
				+ "		   MEM_birth = ? "
				+ "    where MEM_NUM = ? ";
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getMemName());
		pstmt.setString(2, dto.getMemPhone1());
		pstmt.setString(3, dto.getMemPhone1());
		pstmt.setString(4, dto.getMemAddr());
		pstmt.setString(5, dto.getMemEmail());
		pstmt.setString(6, dto.getMemGender());
		pstmt.setTimestamp(7, dto.getMemBirth());
		pstmt.setString(8, dto.getMemNum());
		int i = pstmt.executeUpdate();
		System.out.println(i + " 개 행이(가) 수정되었습니다.");		
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public void memberDelete(String num) {
		con = getConnection();
		String sql = " delete from member where mem_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삭제되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public MemberDTO selectOne(String num) {
		MemberDTO dto = new MemberDTO();
		con = getConnection();
		String sql = "select " + COLUMNS + " from member "
				+ " where mem_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(
						new java.util.Date(
								rs.getDate("mem_regi_date").getTime()));
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return dto;
	}
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		con = getConnection();
		String sql = "select " + COLUMNS + " from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(
						new java.util.Date(
								rs.getDate("mem_regi_date").getTime()));
				list.add(dto);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return list;
	}
	public String numberGenerate() {
		String num = null;
		con = getConnection();
		String sql = "select NVL(max(substr(mem_num,5)),100000) + 1 from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			if(rs.next()) num = rs.getString(1);
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return num;
	}
	public void memberInsert(MemberDTO dto) {
		con = getConnection();
		String sql = "insert into member( " + COLUMNS+ " ) "
				+ " values(?,?,?,?,?,?,?,?,?,?,?)" ;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemNum());
			pstmt.setString(2, dto.getMemName());
			pstmt.setDate(3, new java.sql.Date(
					dto.getMemRegiDate().getTime()));
			pstmt.setString(4, dto.getMemId());
			pstmt.setString(5, dto.getMemPw());
			pstmt.setString(6, dto.getMemPhone1());
			pstmt.setString(7, dto.getMemPhone2());
			pstmt.setString(8, dto.getMemAddr());
			pstmt.setString(9, dto.getMemEmail());
			pstmt.setString(10, dto.getMemGender());
			pstmt.setTimestamp(11, dto.getMemBirth());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삽입되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
}