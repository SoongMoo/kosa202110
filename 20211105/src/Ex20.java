
public class Ex20 {
	public static void main(String[] args) {
		int i = 10;
		while ( i <= 9) { // 1 <= 9, 2<=9, 3<=,...,9<=9
			System.out.println(" 3 * " + i + " = " + 3 * i);
			i++;
		}
		System.out.println("====");
		i = 10;
		do{ // 무조건 한번은 실행을 해야하는 경우
			System.out.println(" 3 * " + i + " = " + 3 * i);
			i++;
		}while (i <= 9);
	}
}
