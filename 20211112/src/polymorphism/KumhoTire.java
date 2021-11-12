package polymorphism;

public class KumhoTire extends Tire{
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}	
	
	@Override
	public boolean roll() { // Ÿ�̾ �������� �޼���
		++accumulatedRotation;
		if (accumulatedRotation< maxRotation) {
			System.out.println(location + "KumhoTire ���� : " +
						(maxRotation - accumulatedRotation) + "ȸ");
			return true;
		}else {
			System.out.println("*** " + location + " KumhoTire ��ũ ***");
			return false;
		}
	}
}