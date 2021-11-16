package package5;

public interface Bank {
	//상수 단위 (만).
	public int MAX_INTEGER = 1000; // 고객이 인출할 수 있는 금액한도.
//	상수는 값을 정해줄 테니 참조만해라.(절대적)
	
	void withDraw(int price); //추상 메소드 : 인출 메소드. (강제적)
	
	void deposit(int price); // 추상 메소드 : 입금 메소드. (강제적)
	
// 고객의 휴면계좌를 찾아주는 메소드.
//	디폴트메소드는 인터페이스에서 기본 제공해주지만, 마음에 안들면 각자 구현해서 써라.(필수 구현은 선택사항) (선택적)
	default String findDormancyAccount(String custId) {
		System.out.println("**금융개정법안 00이후 고객의 휴면계좌 찾아주기 운동**");
		System.out.println("**금융결제원에서 제공하는 로직**");
		return "00은행 000-000-0000-00";
	}
	
	// 정적메소드 : 블록체인 인증을 요청하는 메소드 (절대적) 인터페이스 명으로 호출할 수 있다.
	static void BCAuth(String bankName) {
		System.out.println(bankName + "에서 블록체인 인증을 요청합니다.");
		System.out.println("전 금융사 공통 블록체인 로직 수행");
	}
}
