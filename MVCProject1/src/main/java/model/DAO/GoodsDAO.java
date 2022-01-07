package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.GoodsDTO;

public class GoodsDAO extends DataBaseInfo{
	final String COLUMNS = "goods_num,goods_name,goods_price,goods_date,"
			+ "goods_content, goods_images, goods_qty, goods_company, emp_num,"
			+ "ip_addr";
	String sql;
	public GoodsDTO selectOne(String goodsNum) {
		GoodsDTO dto = new GoodsDTO();
		con = getConnection();
		sql = "select " + COLUMNS + " from goods "
				+ " where goods_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setEmpNum(rs.getString("emp_num"));
				dto.setGoodsCompany(rs.getString("goods_company"));
				dto.setGoodsContent(rs.getString("goods_content"));
				dto.setGoodsDate(rs.getTimestamp("goods_date"));
				dto.setGoodsImages(rs.getString("goods_images"));
				dto.setGoodsName(rs.getString("goods_name"));
				dto.setGoodsNum(rs.getString("goods_num"));
				dto.setGoodsPrice(rs.getInt("goods_price"));
				dto.setGoodsQty(rs.getInt("goods_qty"));
				dto.setIpAddr(rs.getString("ip_addr"));
			}
		}catch(Exception e) {e.printStackTrace();
		}finally {close();}
		return dto;
	}
	public List<GoodsDTO> selectAll(){
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		con = getConnection();
		sql = "select " + COLUMNS + " from goods ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsDTO dto = new GoodsDTO();
				dto.setEmpNum(rs.getString("emp_num"));
				dto.setGoodsCompany(rs.getString("goods_company"));
				dto.setGoodsContent(rs.getString("goods_content"));
				dto.setGoodsDate(rs.getTimestamp("goods_date"));
				dto.setGoodsImages(rs.getString("goods_images"));
				dto.setGoodsName(rs.getString("goods_name"));
				dto.setGoodsNum(rs.getString("goods_num"));
				dto.setGoodsPrice(rs.getInt("goods_price"));
				dto.setGoodsQty(rs.getInt("goods_qty"));
				dto.setIpAddr(rs.getString("ip_addr"));
				list.add(dto);
			}
		}catch(Exception  e) {e.printStackTrace();}
		finally {close();}
		return list;
	}
	public void goodsInsert(GoodsDTO dto) {
		con = getConnection();
		sql = " insert into goods( " + COLUMNS + " )"
			+ " values(?,?,?,?,?,?,?,?,?,?)"; 
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getGoodsName());
			pstmt.setInt(3, dto.getGoodsPrice());
			pstmt.setTimestamp(4, dto.getGoodsDate());
			pstmt.setString(5, dto.getGoodsContent());
			pstmt.setString(6, dto.getGoodsImages());
			pstmt.setInt(7, dto.getGoodsQty());
			pstmt.setString(8, dto.getGoodsCompany());
			pstmt.setString(9, dto.getEmpNum());
			pstmt.setString(10, dto.getIpAddr());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 행이(가) 삽입되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public int autoNum() {
		int i = 0;
		con = getConnection();
		sql = "select seq_num.nextval from  dual";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return i;
	}
}
