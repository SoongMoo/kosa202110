
public class Ex02 { // 부모클래스
	int radius;
	double pi; //3.141592
	public Ex02(int radius, double pi) {
		this.radius = radius;
		this.pi = pi;
	}
	public double area() {
		return radius * radius * pi;
	}
}
