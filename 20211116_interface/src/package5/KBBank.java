package package5;

public class KBBank implements Bank {
	
	// interface 클래스에서 강제적(반드시 재정의해야하는)인 추상메서드 두개만 사용한 KBBank 클래스이다. 
	public void withDraw(int price) {
		System.out.println("KB Bank 의 인출로직.");
		if (price <= Bank.MAX_INTEGER) {
			System.out.println(price + "**(만원)을 인출합니다.** ");
		}else {
			System.out.println(price + "**(만원) 인출실패**");
		}
	}
	
	public void deposit(int price1) {
		System.out.println("KB Bank 의 입금로직.");
		System.out.println(price1 + "**(만원)을 입금합니다.**");
	}
	
}
