package package5;

import java.util.Scanner;

public class kakaoBankTest {

	public static void main(String[] args) {
		
//		kakaoBank class 에서는 추상메소드 두개와 선택적인 default 메소드를 사용했다.
//		블록체인인증에 대한 정적메소드는 인터페이스명으로 바로 호출한다. (Bank.**)
		kakaoBank kakao = new kakaoBank();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인출 금액 (단위 : 만원) : ");
		int price = sc.nextInt();
		kakao.withDraw(price);
		
		System.out.print("입금 금액 (단위 : 만원) : ");
		price = sc.nextInt();
		kakao.deposit(price);
		
		//custID 예(A , B , C)
		sc = new Scanner(System.in);
		System.out.print("custID 를 입력하세요 : ");
		String custId = sc.nextLine();
		kakao.findDormancyAccount(custId);
		
		System.out.print("(블록체인 인증)은행명 : ");
		String bankName = sc.nextLine();
		Bank.BCAuth(bankName);
		sc.close();
		
		
		
		
		
	}

}
