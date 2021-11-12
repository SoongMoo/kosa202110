package method_polymorphism;

public abstract class Vehicle { // 추상클래스
	public abstract void run(); // 추상메서드
	// 부모클래스에 있는 메서드의 내용을 사용하지 않고 
	// 자식 클래스에서 재정의하여 사용하므로 부모클래스에 있는 메서드
	// 내용이 필요 없어서 내용이 없는 메서드를 만들었다.
}
