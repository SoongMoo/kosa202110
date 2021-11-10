
public class Ex05 {
	static int first; // 정적 변수
	static int second;
	int val; // 멤버 변수 , instance
	static { // 정적변수만 초기화할 수 있다.
		first = 20;
		second = 10;
		// val = 10; instance변수는 static 블럭에서 초기화를 할 수 없다.
	}
	public static int add() {
		return first + second;
	}
}
