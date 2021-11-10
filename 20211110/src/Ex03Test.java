
public class Ex03Test {

	public static void main(String[] args) {
		Ex03 ex031 = new Ex03();
		ex031.first = 10;
		ex031.second = 20;
		ex031.val = 30;
		Ex03 ex032 = new Ex03();
		System.out.println(ex032.first); // 0
		System.out.println(ex032.second); // 0
		System.out.println(ex032.val);
		System.out.println(Ex03.val);
		int result = ex031.add();
		System.out.println(result); // 40
		result = ex032.add();
		
		System.out.println(result);
		result = Ex03.sub();
		// 메서드에 static키워드에는 클래스명을 이용해서 사용하기 위한 메서드이다.
		// 메서드내에서 this키워드를 사용할 수 없다.
	}

}
