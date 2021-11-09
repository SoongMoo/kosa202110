
public class Ex04Test {

	public static void main(String[] args) {
		Ex04 ex04;
		ex04 = new Ex04();
		ex04.setData(18, 175.5, false, "이상범");
		String name = ex04.getName();
		System.out.println(name);
		Ex04 ex004;
		ex004 = new Ex04();
		ex004.setAge(35);
		ex004.setGender(false);
		ex004.setHeight(173.5);
		ex004.setName("이숭무");
		name = ex004.getName();
		System.out.println(name);
		
		/// 객체 지향에서는 아래처럼 사용하면 안된다.
		Ex04 ex041 = new Ex04();
		ex041.age = 20;
		ex041.gender = true;
		ex041.height = 160.5;
		ex041.name = "박준현";
		System.out.println(ex041.name);
		
	}

}
