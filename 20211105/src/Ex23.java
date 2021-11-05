import java.util.Scanner;

public class Ex23 {

	public static void main(String[] args) {
		// num = int(input("첫번째숫자를 입력해주세."))
		// Scanner
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요. : ");
		String name = sc.next();
		System.out.println("이름은 : " + name);
		System.out.print("숫자를 입력해주세요. : ");
		int num = sc.nextInt();
		System.out.println("숫자 : " + num);
		*/
		// 문제: 단과 곱의 범위를 입력 받아 구구단을 출력하시오.
		Scanner sc = new Scanner(System.in);
		while(true) { // 무조건 실행하기 위해서 true를 사용
			System.out.print("시작 단을 입력해 주세요. :");
			int startDan = sc.nextInt();
			System.out.print("마지막 단을 입력해 주세요. :");
			int endDan = sc.nextInt();
			System.out.print("시작 곱을 입력해 주세요. :");
			int startGop = sc.nextInt();
			System.out.print("마지막 곱을 입력해 주세요. :");
			int endGop = sc.nextInt();
			
			int dan = startDan;
			while (dan <= endDan) {
				int gop = startGop;
				while (gop <= endGop) {
					System.out.println(dan + "*" + gop +"="+dan*gop);
					gop++;
				}
				dan++;
			}
			System.out.println("종료하려면 'y'아니면 아무키나. : ");
			String stop = sc.next();
			if(stop.equals("y")) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
}