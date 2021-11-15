package multi_implement;

public class RemoteControlExample {

	public static void main(String[] args) {
		SmartTelevision tv = new SmartTelevision();
		Searchable sc = tv;
		RemoteControl rc = tv;
		// 부모에 있는 것만 사용 가능하다.
		sc.search("이숭무");
		rc.turnOn();
		rc.turnOff();
		// 상속 받은 모든 것을 사용할 수 있다.
		tv.search("이상범");
		tv.turnOn();
		tv.turnOff();
	}

}
