
public class DmbCellPhoneTest {

	public static void main(String[] args) {
		DmbCellPhone ex= new DmbCellPhone("자기폰", "검정", 5);
		/// 부모로 부터 상속 받은 메서드 사용
		ex.powerOn();
		ex.bell();
		ex.sendVoice("여보세요");
		ex.receiveVoice("이숭무 폰 맞나요");
		ex.sendVoice("안녕하세요");
		ex.hangUp();
		
		// 자식 클래스메서드 실행
		ex.turnOnDmb();
		ex.changeChannelDmb(12);
		ex.turnOffDmb();
	}

}
