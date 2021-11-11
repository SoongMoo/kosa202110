
public class Ex01Test {

	public static void main(String[] args) {
		Ex01 ex01 = new Ex01();
		Ex01 ex02 = new Ex01();
		Ex01 ex03 = new Ex01();
		// 10000   20000
		if(ex01 == ex02) {
			System.out.println("같다");
			
		}else {
			System.out.println("다르다");
		}
		ex01.first = 20;
		System.out.println(ex02.first);
		System.out.println(ex01.first);
		
		Singleton s1 = Singleton.getInstance();// 30000
		Singleton s2 = Singleton.getInstance(); // 30000
		if(s1 == s2) {
			System.out.println("s1과 s2는 같다.");
		}else {
			System.out.println("s1과 s2는 다르다.");
		}

	}
}
