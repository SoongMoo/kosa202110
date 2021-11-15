package default_method;

public class ClassB extends ClassA{
	public void method03() {
		System.out.println("ClassB-method03");
	}
	@Override
	public void method01() { // 추상 메서드 
		System.out.println("ClassB-method01");
	}
	// 상속 받은 일반 메서드는 오버라이드를 하지 않아도 된다.
}
