package inheritance;

public class Ex09 extends Ex08{
	// public Ex09() {}
	int val;
	public Ex09(int first, int second, int val) {
		super(first, second);
		this.val = val;
	}
	public void sub() {
		result = first - second;
	}
	public void mul() {
		result = first * second;
	}
	@Override
	public void div() { // 부모가 가진 메서드를 자식에서 재정의
		if (second == 0) {
			result = 0;
		}else {
			result = first / second;
		}
	}
	public void div1() {
		super.div(); // 재정의된 부모 클래스에 있는 메서드를 호출한다.
	}
}
