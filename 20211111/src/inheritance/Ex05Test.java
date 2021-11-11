package inheritance;

public class Ex05Test {

	public static void main(String[] args) {
		Ex05 ex05 = new Ex05();
		ex05.setFirst(20); // Ex04
		ex05.setSecond(30); //Ex04
		ex05.add();  // Ex04
		System.out.println(ex05.getResult());
		ex05.sub(); // Ex05
		System.out.println(ex05.getResult());
	}

}
