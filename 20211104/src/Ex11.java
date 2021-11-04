
public class Ex11 {

	public static void main(String[] args) {
		/*    if 조건식:
		 * 			명령어1
		 *          명령어2
		 *          ...
		 */
		/*
		 * if (조건식){
		 * 		명령어1;
		 * 		명령어2;
		 * 		...
		 * }
		 * java에서는 들여쓰기를 가독성을 높이기 위해 사용한다.
		 */
		int i = 10;
		if (i < 20) System.out.println("작다");
		if (i > 20) { 
			System.out.println("i는 ");

			System.out.println("10보다 작다");
			System.out.println("...");
		}
		int money = 3000;
		// 돈 3000원을 초가하면 차를 타고 가시오.
		if (money > 3000)
			System.out.println("차를 타고 가시오");
			System.out.println("if문이 종료되었습니다.");
		
		if (money > 3000) {
			System.out.println("차를 타고 가시오");
		}
			System.out.println("if문이 종료되었습니다.");
		if (money > 3000)
			System.out.println("차를 타고 가시오");
		
		System.out.println("if문이 종료되었습니다.");
	}
}


