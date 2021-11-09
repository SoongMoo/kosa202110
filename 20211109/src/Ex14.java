
public class Ex14 {
	int result;
	int first;
	int second;
	int add; // 변수
	public Ex14(int first, int second) {
		this.first = first;
		this.second = second;
	}
	// 메서드의 4가지 유형
	// 1.  입력 값이 있고 결과값(반환형)이 있는 메서드
	public int add(int num1, int num2) {
		return  num1 + num2;
	}
	// 메서드 오버로딩
	public int div(int num1, int num2) {
		return num1 / num2;
	}
	// 2. 입력값은 있고 결과값(반환형)이 없는 메서드
	public void sub(double num1, int num2) {
		this.result = (int)num1 - num2;
		System.out.println(this.result);
	}
	// 메서드 오버로딩  // 매개변수의 순서가 다르다.
	public int sub(int num1, double num2) {
		return num1 - (int)num2 ;
	}
	// 3. 입력값은 없고 결과값이 있는 메서드
	public int mul() {
		return first * second;
	}
	// 4. 입력값이 없고 결과값이 없는 함수
	public void div() {
		System.out.println(this.first / this.second );
	}
}
