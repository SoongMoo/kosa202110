
public class Ex11 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i +"번찍었습니다. ");
		}
		System.out.println("나무 넘어갑니다.");
		System.out.println("=========");
		for (int i = 1; i <= 10; i++) {
			System.out.println(i +"번찍었습니다. ");
			if (i == 10) {
				System.out.println("나무가 넘어갑니다.");
			}
		}
	}
}
