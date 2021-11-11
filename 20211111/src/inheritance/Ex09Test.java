package inheritance;

public class Ex09Test {

	public static void main(String[] args) {
		Ex09 ex09 = new Ex09(30, 10, 15);
		ex09.add();
		System.out.println(ex09.getResult());
		ex09.div();
		System.out.println(ex09.getResult());
		ex09.sub();
		System.out.println(ex09.getResult());
		Ex09 ex090 = new Ex09(0, 10, 15);
		ex090.div();
		System.out.println(ex090.getResult());
		Ex09 ex091 = new Ex09(10, 0, 15);
		ex091.div();
		ex091.div1();
		
		
	}

}
