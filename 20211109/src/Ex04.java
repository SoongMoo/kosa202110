
public class Ex04 {
	int age;
	double height; // ¸â¹ö ÇÊµå, ¸â¹ö º¯¼ö
	boolean gender;
	String name;
	public void setData(int age, double height,
			boolean gender, String name) {
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.name = name;
	}
	// setter
	public void setAge(int age) {
		this.age = age;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public void setName(String  name) {
		this.name = name;
	}
	// getter
	public int getAge() {
		return this.age;
	}
	public double getHeight() {
		return this.height;
	}
	public boolean getGender() {
		return this.gender;
	}
	public String getName() {
		return this.name;
	}
}





