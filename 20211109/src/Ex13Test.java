
public class Ex13Test {
	public static void main(String [] args) {
		/*
		// 6단 출력
		for(int i = 1 ; i <= 9; i++) {
			System.out.println("6 * " + i + " = " +6*i);
		}
		// 8단 출력
		for(int i = 1 ; i <= 9; i++) {
			System.out.println("8 * " + i + " = " +8*i);
		}
		// 3단 출력
		for(int i = 1 ; i <= 9; i++) {
			System.out.println("3 * " + i + " = " +3*i);
		}
		*/
		gugu(3); // argument : 인자
		gugu(6);
		gugu(7);
		int result = 10 + 3;
		System.out.println(result);
		result = 30 + 6;
		System.out.println(result);
		result = add(20 , 10);
		System.out.println(result);
		int result1 = add(30, 10);
		System.out.println(result1);
	} // 반복적으로 사용하는 코드가 있는 경우 함수로
	//                    dan : parameter : 매개변수
	public static void gugu(int dan) { 
		for(int i = 1 ; i <= 9; i++) {
			System.out.println(dan+" * "+i+" = "+dan*i);
		}
	}
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
}
