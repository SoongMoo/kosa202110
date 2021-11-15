package interface_instanceof;

public class Driver {
	// instanceof는 클래스와 객체가 같은지 비교할 때 사용
	public void drive(Vehicle vehicle ) {
		if(vehicle instanceof Bus) { // instanceof객체를 비교할 때 사용
			// vehicle객체가 Bus클래스로 만들어진 객체입니까?
			// instanceof의 결과값은 boolean이다.
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		vehicle.run();
	}
}
