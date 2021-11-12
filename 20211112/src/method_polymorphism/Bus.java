package method_polymorphism;

public class Bus extends Vehicle{
	@Override
	public void run() {
		System.out.println("차량이 달립니다.");
	}
}
