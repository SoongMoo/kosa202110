package method_polymorphism;

public class DriverExample {
	public static void main(String[] args) {
		Bus bus = new Bus();
		Taxi texi = new Taxi();
		bus.run();
		texi.run();
		Vehicle v = bus;
		v.run();
		v = texi;
		v.run();
		
		drive(bus);
		drive(texi);
		
		Driver driver = new Driver();
		driver.drive(texi);
		driver.drive(bus);
		
	}
	public static void drive(Vehicle v) {
		v.run();
	}
}
