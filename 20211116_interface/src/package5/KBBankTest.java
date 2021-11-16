package package5;

import java.util.Scanner;

public class KBBankTest {

	public static void main(String[] args) {
		
		// interface 클래스에서 강제적(반드시 재정의해야하는)인 추상메서드 두개를 사용한 KBBank 클래스이다. 
		KBBank kb = new KBBank();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("인출 금액 (단위 : 만원) : ");
		int price = sc.nextInt();
		kb.withDraw(price);
		
		System.out.print("입금 금액 (단위 : 만원) : ");
		price = sc.nextInt();
		kb.deposit(price);
		sc.close();
		
	}

}
