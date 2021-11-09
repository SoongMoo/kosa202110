
public class Ex14Test {

	public static void main(String[] args) {
		Ex14 ex14 = new Ex14(50, 20);
		int num = ex14.add(20, 10);
		System.out.println(num);
		ex14.sub(30, 15.0);
		num = ex14.mul();
		System.out.println(num);
		ex14.div();
		ex14.add = 10;
		System.out.println(ex14.add);
	}

}
