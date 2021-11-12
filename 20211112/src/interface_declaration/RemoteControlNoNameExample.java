package interface_declaration;

public class RemoteControlNoNameExample {
	
	public static void main(String[] args) {
		//필드
		RemoteControl rc = new RemoteControl(){
			int vol;
			@Override
			public void turnOn() {
				System.out.println("cd를 킵니다.");
			}
			@Override
			public void turnOff() {
				System.out.println("cd를 끔니다.");
			}
			@Override
			public void setVolume(int volume) {
				if(volume > RemoteControl.MAX_VOLUME) {
					vol = RemoteControl.MAX_VOLUME;
				}else if(volume < RemoteControl.MIN_VOLUME) {
					vol = RemoteControl.MIN_VOLUME;
				}else {
					vol = volume;
				}
				System.out.println(" 현재 cd볼륨은 " + vol + "입니다.");
			}
		};
		rc.turnOn();
		rc.turnOff();		
	}
}
