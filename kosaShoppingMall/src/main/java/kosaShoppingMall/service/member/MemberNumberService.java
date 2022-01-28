package kosaShoppingMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kosaShoppingMall.command.MemberCommand;
import kosaShoppingMall.mapper.MemberMapper;


@Service
public class MemberNumberService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MemberCommand memberCommand) {
		String memberNum = memberMapper.numberGenerate();
		//model.addAttribute("memberNum", memberNum);
		memberCommand.setMemberNum(memberNum);
	}
}
