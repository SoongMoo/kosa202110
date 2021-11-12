package interface_declaration;

public interface RemoteControl {
	// 생성자x, 필드x, 일반 메서드x, 생성자x
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	//// 자바 8번전부터 추가
	//디폴트 메소드
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리를 한다.");
		}else {
			System.out.println("무음 해제를 한다.");
		}
	}
	//정적 메소드
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}




