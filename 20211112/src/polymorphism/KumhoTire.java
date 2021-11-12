package polymorphism;
//                B              A
public class KumhoTire extends Tire{ // Tire = KumhoTire
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}	
	
	@Override
	public boolean roll() { // 타이어가 굴러가는 메서드
		++accumulatedRotation;
		if (accumulatedRotation< maxRotation) {
			System.out.println(location + "KumhoTire 수명 : " +
						(maxRotation - accumulatedRotation) + "회");
			return true;
		}else {
			System.out.println("*** " + location + " KumhoTire 펑크 ***");
			return false;
		}
	}
}
