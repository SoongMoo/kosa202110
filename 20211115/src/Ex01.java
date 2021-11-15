
public abstract class Ex01 {
	int first; // 멤버필드
	// 생성자
	public Ex01(int first) {
		this.first = first;
	}
	// 추상메서드
	public abstract void method01();//정의되어 있지 않은 메서드
	// 일반 메서드
	public void method02() {
		System.out.println("Ex01-method");
	}
	
}
