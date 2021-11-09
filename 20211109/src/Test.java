
public class Test {

	public static void main(String[] args) {
		Board board = 
				new Board(1,"제목","상장범아빠","내용",
						"192.168.0.100", 2);
		System.out.println("제목 : " +  board.getSubject());
		System.out.println("글쓴이 : " + board.getWriter());
		System.out.println("내용 : " + board.getContent());
		System.out.println("ip : " + board.getIp());
		System.out.println("방문자 수 " + board.getReadCount());
		
		Car car = new Car("현대","소나타","검정",240);
		Car car1 = new Car();
		car1.setColor("흰색");
		car1.setCompany("기아");
		car1.setModel("k7");
		car1.setMaxSpeed(250);
		System.out.println(car1.getCompany());
	}
}