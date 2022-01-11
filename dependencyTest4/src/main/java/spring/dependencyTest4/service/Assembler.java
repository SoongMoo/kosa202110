package spring.dependencyTest4.service;

import spring.dependencyTest4.DTO.MemberDao;

public class Assembler { // 객체 조립기
	 MemberDao memberDao;
	 MemberPrinter printer;
	 MemberRegisterService memberRegisterService;
	 MemberListPrinter memberListPrinter;
	 ChangePasswordService changePasswordService;
	 MemberInfoPrinter memberInfoPrinter;
	 public Assembler() {
		 this.memberDao = new  MemberDao();
		 this.printer = new MemberPrinter();
		 this.memberRegisterService 
		 			= new MemberRegisterService(memberDao);
		 this.memberListPrinter =
				 new MemberListPrinter(memberDao, printer);
		 this.memberInfoPrinter = 
				 new MemberInfoPrinter(memberDao);
	 }
	public MemberDao getMemberDao() {
		return memberDao;
	}
	public MemberPrinter getPrinter() {
		return printer;
	}
	public MemberRegisterService getMemberRegisterService() {
		return memberRegisterService;
	}
	public MemberListPrinter getMemberListPrinter() {
		return memberListPrinter;
	}
	public ChangePasswordService getChangePasswordService() {
		return changePasswordService;
	}
	public MemberInfoPrinter getMemberInfoPrinter() {
		return memberInfoPrinter;
	}
}
