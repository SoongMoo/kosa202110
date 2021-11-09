
public class Ex061 {
	String name;
	int age;
	double height;
	/// 자바에서 생성자는 클래스명과 같아야 한다.
	// 생성자
//  접근지정자 클래스명(매개변수,...)
	public Ex061(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
		System.out.println("생성자 실행");
	}
	// 메서드 : 
//  접근지정자 반환형 함수명 (매개변수)
	// setter
	     //반환형(void:반환할게 없다)
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	// getter
	public int getAge() {
		// 정수를 반환
		return this.age;
	}
	public double getHeight() {
		return this.height;
	}
	public String getName() {
		return this.name;
	}
}
