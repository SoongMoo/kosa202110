
public class Ex1 {

	public static void main(String[] args) {
		/* 1. 반복을 위한 변수 i의 초기값이 1이고 10번을 반복 
		 * 수행을 할 때 i가 출력되도록 하시오.
		 */
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		/* 2. 반복을 위한 변수 i의 초기값이 1일고 10번을 반복 수행을 할 때 
		 * 변수 y가 반복될 때마다 1씩 증가하는 값이 출력되도록 하시오.
		 */
		int y = 1;
		for(int i = 1 ; i <= 10 ; i++) {
			System.out.println(y);
			y++;
		}
		
		// 3.
		for(int i = 1; i <= 10 ; i++) {
			int y1 = 0; // 반복문 안에 변수 선언이 가능
			y1++; // y1은 0으로 초기화가 되었으므로 항상 1이된다.
			System.out.println(y1);// 1,1,1,1,1,1,1,1
			System.out.println(i); // 1,2,3,4,5,6,7,8,9,10
		}
		// 4. 
		for(int i = 11; i <= 21; i ++) { // i를 반복변수
			System.out.println("이쓰앰님을 전적으로 믿으셔야합니다.");
		}
		// 반복변수 i의 초기값은 10이고 10번 반복, i를 2씩 증가
		for(int i =10 ; i<= 19 ; i+=2) {
			System.out.println(i);
		}
		// continue를 사용
		for(int i = 10; i<= 19 ; i++) {
			if(i % 2 != 0) continue;
			System.out.println(i);
		}
		// i의 초기값은 10이고 25회 반복하되 i는 4씩증가
		int y2 = 1;
		for(int i = 10; i<= 109; i+=4) {
			System.out.println(y2);
			y2++;
		}	
		// i의 초기 값은 12이고 20회 반복을 할때
		// "개발자는 들여쓰기를 잘해야합니다"를 4회 출력
		for(int i = 12; i <= 31 ; i+=5) {
			System.out.println("개발자는 들여쓰기를 잘해야합니다");
		}
		// 구구단 7단을 출력하되 홀수만을 출력하되 반복변수는 사용하지 말것.
		int y3 = 1;
		for(int i = 1; i <= 9; i++) {
			System.out.println(" 7 * "+ y3 + " = " + 7 * y3);
			y3++;
		}
		// Math.random()함수를 이용해서 1~45값 중 하나의 값을 받아 
		// 그 값만큼 반복을 하시오.
		int num = (int)(Math.random() * 45) + 1;
		for(int i = 1; i <= num; i++) {
			System.out.println(i);
		}
		// 1부터 10번까지 반복을 할 때 Math.random()으로 1부터 45까지의 값을 
		// 받아 짝수일 때만 3을 곱해서 출력하시오.
		// 단 10회 반복이 되어야 한다.
		for(int i = 1; i<=10 ; i++) {
			int num1 = (int)(Math.random() * 45 ) + 1;
			if(num1 % 2 == 0 ) {
				System.out.println(" 3 * " +  num1 + " = " + 3 * num1);
			}else i--; // 1증가 된것을 다시 1감소
		}
		// x = 10; y = 19; z = 2일때
		// i는 초기값 x를 가지고 y만큼 반복을 하되 z만큼 증가를 하시오.
		int x = 10;
		y = 19;
		int g = 2;
		for(int i = x; i <= y; i += g) {
			System.out.println(i);
		}
		
		// 변수 i는 1부터 10까지 반복을 하고 변수 j는 100부터 91이 될때까지 
		// 반복을 하여 "프로그램을 잘 하려면 들여쓰기를 잘하자"를 출력
		for(int i=1, j = 100; i <= 10 && j >= 91 ; i++, j-- ) {
			System.out.println("프로그램을 잘 하려면 들여쓰기를 잘하자");
		}
		/*
		 * 6단 시작
			6 * 4= 24
			6 * 5= 30
			6 * 6= 36
			6단 끝
			7단 시작
			7 * 4= 28
			7 * 5= 35
			7 * 6= 42
			7단 끝
		 */
		for (int i = 4; i <= 6; i++) {
			System.out.println(i + "단 시작");
			for(int j = 3; j <= 8; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			}
			System.out.println(i + "단 끝");
		}
		System.out.println("========");
		
		for (int i = 4; i <= 6; i++) {
			System.out.println(i + "단 시작");
			for(int j = 3; j <= 8; j++) {
				System.out.print(i + " * " + j + " = " + i * j + "  ");
			}
			System.out.println();
			System.out.println(i + "단 끝");
		}
		/*
		 * <table>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>
			</table>
		 */
		System.out.println("<table>");
		for(int i =1 ; i <= 4; i++) {
			System.out.println("<tr><td> 1 </td><td> 2 </td><td> 3 </td><td> 4 </td></tr>");
		}
		System.out.println("</table>");
	}
}
