package package5;

public class kakaoBank implements Bank {
	
//	kakaoBank class 에서는 추상메소드 두개와 선택적인 default 메소드를 사용했다.
	public void withDraw(int price) {
		System.out.println("Kakao Bank 의 인출로직.");
		if (price <= Bank.MAX_INTEGER) {
			System.out.println(price + "**(만원)을 인출합니다.** ");
		}else {
			System.out.println(price + "**(만원) 인출실패**");
		}
	}
	
	public void deposit(int price1) {
		System.out.println("Kakao Bank 의 입금로직.");
		System.out.println(price1 + "**(만원)을 입금합니다.**");
	}
	
	// interface 에서 가져온 default 메소드. (사용할 때는 접근제한자를 바꾸어 주어야 한다.)
	public String findDormancyAccount(String custId) {
		System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
		System.out.println("**금융결제원에서 제공하는 로직**");
		switch (custId) {
		case "A" :
			System.out.println("kakao은행 000-000-0000-01");
			break;
		case "B" :
			System.out.println("kakao은행 000-000-0000-02");
			break;
		case "C" :
			System.out.println("kakao은행 000-000-0000-03");
			break;
		}
		return custId;
	}
}
