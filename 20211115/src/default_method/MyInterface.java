package default_method;

public interface MyInterface {
	public void method1(); // 재 정의
	
	// 오버라이드를 할 수도 있고 안 할 수도 있는 메서드
	public default void method2() {
		System.out.println("MyInterface-method2 실행");
	}
}
