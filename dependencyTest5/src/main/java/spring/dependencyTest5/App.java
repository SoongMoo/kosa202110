package spring.dependencyTest5;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dependencyTest5.DTO.RegisterRequest;
import spring.dependencyTest5.service.ChangePasswordService;
import spring.dependencyTest5.service.MemberInfoPrinter;
import spring.dependencyTest5.service.MemberListPrinter;
import spring.dependencyTest5.service.MemberRegisterService;



public class App {
	// 의존 객체 조립기 생성 
	//static Assembler assembler = new Assembler();
	static GenericXmlApplicationContext ctx;
	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("명렁어를 입력하세요:");
			String command = sc.nextLine();
			if(command.startsWith("new ")) {
				// 의존객체 //dependency object 
				String [] arg = command.split(" ");
				//new high 이숭무 1234 1234
				//    [1]   [2]   [3]  [4]
				if(arg.length != 5) {
					printHelp();
					System.out.println();
					continue;
				}
				RegisterRequest req = new RegisterRequest();
				req.setEmail(arg[1]);
				req.setName(arg[2]);
				req.setPassword(arg[3]);
				req.setConfirmPassword(arg[4]);
				boolean bl = req.isPasswordEqualConfirmPassword();
				if(!bl) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					continue;
				}
				// 의존객체
				MemberRegisterService action= 
						ctx.getBean("memberRegisterService",
								MemberRegisterService.class);
				action.execute(req);
			}else if(command.equals("list")) {
				// 의존 객체
				MemberListPrinter listPrint =
						ctx.getBean("memberListPrinter",
								MemberListPrinter.class);
				listPrint.printAll();
			}else if(command.startsWith("change ")) {
				String [] arg = command.split(" ");
				if(arg.length != 4) {
					printHelp();
					continue;
				}
				ChangePasswordService action = 
						ctx.getBean("changePasswordService",
								ChangePasswordService.class);
				action.execute(arg[1], arg[2], arg[3]);
			}else if(command.startsWith("info ")) {
				String [] arg = command.split(" ");
				if(arg.length != 2) {
					printHelp();
					continue;
				}
				MemberInfoPrinter action =
						ctx.getBean("memberListPrinter",
								MemberInfoPrinter.class);
				action.execute(arg[1]);
			}else if(command.equals("exit")) {
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}else {
				printHelp();
			}
		}
		
	}
	public static void printHelp() {
		System.out.println();
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println("list");
		System.out.println("info 이메일");
		System.out.println("프로그램 종료는 exit");
	}
}
