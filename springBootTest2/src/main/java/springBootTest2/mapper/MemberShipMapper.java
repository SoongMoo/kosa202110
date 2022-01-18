package springBootTest2.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import springBootTest2.domain.MemberDTO;

@Component
@Repository(value = "springBootTest2.mapper.MemberShipMapper")
public interface MemberShipMapper {
	public MemberDTO selectOne(String memid);
	public Integer memberInsert(MemberDTO dto);
	public Integer memberUpdate(MemberDTO dto);
	public Integer updatePassword(MemberDTO dto);
	public Integer memberDrop(String memId);
}
