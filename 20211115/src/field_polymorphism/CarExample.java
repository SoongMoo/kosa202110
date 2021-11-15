package field_polymorphism;

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		myCar.backLeftTire = new KumhoTire();
		myCar.frontLeftTire = new HankookTire(); 
		myCar.run();
	}
}
