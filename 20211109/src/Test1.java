
public class Test1 {
	public static void main(String[] args) {
		Car car = new Car();
		car.setCompany(args[0]);
		car.setModel(args[1]);
		car.setColor(args[2]);
		car.setMaxSpeed(Integer.parseInt(args[3]));
		System.out.println(car.getModel());
		System.out.println(car.getCompany());
	}
}
