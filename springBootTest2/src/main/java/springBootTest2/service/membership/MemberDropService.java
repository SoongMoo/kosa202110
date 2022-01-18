package springBootTest2.service.membership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import springBootTest2.mapper.MemberShipMapper;
@Component
@Service
public class MemberDropService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String memId) {
		memberShipMapper.memberDrop(memId);
	}
}
