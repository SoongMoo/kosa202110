
public class Ex02Test {
	public static void main(String[] args) {
		// final변수는 생성자를 통해서 초기화가 가능 
		Ex02 ex02 = new Ex02(10, 20,"dltndan");
		// 초기화된 값을 변경하지 못한다. 
		// ex02.first = 20;
		Ex02 ex021 = new Ex02(30, 40,"abanbsbj");
		System.out.println(ex02.first); // 10
		System.out.println(ex021.first); // 30
		// 객체마다 final변수의 값을 별개로 가질 수 있다.
	}
}