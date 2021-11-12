
public class Member {
	int age;
	double height;
	String name;
	// ������
	public Member() {} //����Ʈ ������
	public Member(int age) { //�޼��� �����ε�
		this.age = age;
	}
	public Member(String name) {
		this.name = name;
	}
	public Member(int age, double height, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	public Member(double height, int age, String name) {
		this.age = age;
		this.height = height;
		this.name = name;
	}
	// �޼���
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}