package field_array;

public class Car {
	int i1 = 1;
	int i2 = 2;
	int i3 = 3;
	int i4 = 4;
	int i [] = {1,2,3,4};
	
	Tire tire1 = new KumhoTire();
	Tire tire2 = new KumhoTire();
	Tire tire3 = new HankookTire();
	Tire tire4 = new HankookTire();
	Tire tires[] = {
			new KumhoTire(), 
			new KumhoTire(),
			new HankookTire(),
			new HankookTire()
			};
	void run() {
		/*
		tires[0].roll();
		tires[1].roll();
		tires[2].roll();
		tires[3].roll();
		*/
		for(Tire tire : tires) {
			tire.roll();
		}
	}
	
	
}
