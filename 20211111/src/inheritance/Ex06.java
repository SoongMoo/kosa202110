package inheritance;

public class Ex06 {
	int first;
	int second;
	int result;
	public Ex06() {
		System.out.println("부모클래스 객체가 생성되었습니다.");
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getResult() {
		return result;
	}
	public void add() {
		result = first + second;
	}
}
