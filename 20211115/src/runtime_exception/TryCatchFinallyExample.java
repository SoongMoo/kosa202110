package runtime_exception;

public class TryCatchFinallyExample {
	public static void main(String[] args) {
		Point1 point = null; // Point point = new Point();
		try {
			point.print();
		}catch(NullPointerException e) {
			point = new Point1();
			point.print();
		}finally {
			System.out.println("프로그램이 정상적으로 실행 중입니다.");
		}
	}
}
class Point1{
	public void print() {
		System.out.println("출력");
	}
}
