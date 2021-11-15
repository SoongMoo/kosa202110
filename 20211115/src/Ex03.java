
public interface Ex03 {
	//상수, 추상메서드
	static final int FISRT = 10;
	public void menthod01(); // 추상메서드// 오보라이딩
	// 생성자가 없다.
	// 일반메서드 없다. // 멤버필드 없다.
	// 메서드가 하는 역할은 외부로부터 멤버필드에 값을 전달 받거나 
	// 멤버필드에 있는 값을 외부에 전달하기 위해서 사용, setter, getter
	default void method02() {
		System.out.println("default-method");
	}
	static void method03() {
		System.out.println("static-method");
	}
}
