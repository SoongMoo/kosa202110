
public class CalulatorTest {
	public static void main(String[] args) {
		Calulator cal = new Calulator();
		Calulator cal1 = new Calulator();
		cal.add(10, 20);
		System.out.println(cal.result);
		cal1.add(20, 30);
		System.out.println(cal1.result);
	}
}
