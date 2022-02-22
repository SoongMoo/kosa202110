package kosaShoppingMall.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import kosaShoppingMall.domain.AuthInfo;
import kosaShoppingMall.domain.MemberDTO;
import kosaShoppingMall.domain.StartEndPageDTO;

@Repository(value = "kosaShoppingMall.mapper.MemberMapper")
public interface MemberMapper {
	public String numberGenerate();
	public Integer memberInsert(MemberDTO dto);
	public List<MemberDTO> selectAll(StartEndPageDTO dto);
	public MemberDTO selectDTO(String memberNum);
	public Integer memberUpdate(MemberDTO dto);
	public Integer memberDelete(String memberNum);
	public int memberCount(String memberWord);
	public Integer changPw(AuthInfo authInfo);
	public Integer joinOkUpdate(MemberDTO dto);
	public Integer memberRemove(HashMap<String, Object> conditioncondition);
}