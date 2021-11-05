
public class Ex22 {

	public static void main(String[] args) {
		// do~while : 무조건 한번 실행을 한후 비교를 한다.
		int num1,num2,num3;
		num1 = (int)(Math.random() * 45 ) + 1; // 1~45 // 2
		num2 = (int)(Math.random() * 45 ) + 1; // 1~45 // 2
		System.out.println(num1); // 30
		System.out.println(num2); // 30
		while(num1 == num2) {
			num2 = (int)(Math.random() * 45 ) + 1;
		}
		System.out.println("========");
		num1 = (int)(Math.random() * 45 ) + 1;
		do {
			num2 = (int)(Math.random() * 45 ) + 1;
		}while(num1 == num2);
		do {
			num3 = (int)(Math.random() * 45 ) + 1;
		}while(num1 == num3 || num2 == num3);
         	
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);	
	}
}