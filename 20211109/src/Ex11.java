
public class Ex11 {
	String company;
	String model;
	String color;
	int maxSpeed;
	public Ex11() {}
	public Ex11(String company, String model, 
			int maxSpeed) {
		this(company, model);
		/*this.company = company;  /// 
		this.model = model;  /// 공통코드
		*/
		this.maxSpeed = maxSpeed;
	}
	public Ex11(String company, String model, 
			String color) {
		this(company, model);
		/*
		this.company = company; ///
		this.model = model; /// 공통코드
		*/
		this.color = color;
	}
	/// 공통코드를 관리하는 생성자
	public Ex11(String company, String model){
		this.company = company;
		this.model = model;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}	
}
