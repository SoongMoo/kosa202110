package kosaShoppingMall.service.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosaShoppingMall.mapper.MemberMapper;
@Service
public class MemberDelsService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String[] memDels) {
		List<String> cs = new ArrayList<String>();
		for(String num :memDels) {
			cs.add(num);
		}
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.put("memberNum", cs);
		memberMapper.memberRemove(condition);
	}

}
