package finalTest;

public class Ex02Test {

	public static void main(String[] args) {
		Ex02 ex02 = new Ex02();
	
		ex02.setFirst(20);
		ex02.setSecond(10);
		int result = ex02.add();
		System.out.println(result);
		result = ex02.div();
		System.out.println(result);
		ex02.setSecond(0);
		result = ex02.div();
	}
}
