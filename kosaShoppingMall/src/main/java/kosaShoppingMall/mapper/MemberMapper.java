package kosaShoppingMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.MemberDTO;

@Repository(value = "kosaShoppingMall.mapper.MemberMapper")
public interface MemberMapper {
	public String numberGenerate();
	public Integer memberInsert(MemberDTO dto);
	public List<MemberDTO> selectAll();
	public MemberDTO selectDTO(String memberNum);
	public Integer memberUpdate(MemberDTO dto);
	public Integer memberDelete(String memberNum);
}