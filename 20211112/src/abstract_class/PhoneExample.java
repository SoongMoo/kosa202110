package abstract_class;

public class PhoneExample {

	public static void main(String[] args) {
		// 부모 클래스로 객체 생성 : 추상 메서드를 가진 클래스는 객체 생성을 할 수 없다.
		// Phone phone = new Phone();
		// 추상 클래스는 직접 객체 생성을 할 수 없다.
		//Ex01 ex01 = new Ex01();
		SmartPhone p = new SmartPhone("이숭무");
		p.turnOn();
		p.turnOff();
	}

}
