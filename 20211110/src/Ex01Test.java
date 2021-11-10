
public class Ex01Test {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01(20, 10);
		int result = ex01.add(); // 객체 내에 있는 함수를 외부에서 사용
		System.out.println(result);	
		result = add(30, 10);
		System.out.println(result);
	}
	public static int add(int num1,  int num2) {
		return num1 + num2;
	}

}
