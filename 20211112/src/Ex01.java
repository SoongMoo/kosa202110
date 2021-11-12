
public  class Ex01 {
	int radius;
	double pi;

	public void setRadius(int radius) {
		this.radius = radius;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	public int getRadius() {
		return radius;
	}
	public double getPi() {
		return pi;
	}
	public double areaCircle() {
		 return radius * radius * pi;
	}
	
}
