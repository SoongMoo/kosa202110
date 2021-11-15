
public class Ex02 extends Ex01{
	public Ex02(int first) {
		super(first);
	}
	public void method2() {
		//추상메서드 있는 클래스는 객체생성을 할 수 없다.
		//Ex01 ex01 = new Ex01(12);
	}
	// 추상메서드가 있는 추상 클래스를 상속을 하면 추상메서드는 오버라이딩을 해야함 
	@Override
	public void method01() {
		System.out.println("Ex02-method1");		
	}
}
