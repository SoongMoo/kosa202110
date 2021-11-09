
public class Ex06Test {

	public static void main(String[] args) {
		Ex06 ex06; // 변수 선언
		ex06 = new Ex06(); // 객체 생성
		// 멤버 필드 초기화
		ex06.setDate("이숭무", 30, 175.2);
		String name = ex06.getName();
		System.out.println(name);
		// 객체생성과 동시에 멤버 필드에 초기화 : 생성자
		Ex061 ex061 = new Ex061("이상범", 18, 175.5);
		// 객체생성시에 생성자가 자동으로 실행
		// 멤버필드를 초기화할 때 사용
		System.out.println(ex061.getAge());
		
		
		

	}

}
