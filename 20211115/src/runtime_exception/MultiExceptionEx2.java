package runtime_exception;

public class MultiExceptionEx2 {
	public static void main(String[] args) {
		int data1 = 0;
		int data2 = 0;
		try {
			data1 = Integer.parseInt(args[0]);
			data2 = Integer.parseInt(args[1]);
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data1 / data2);
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력값이 2개가 필요합니다.");
		}catch(ArithmeticException e) {
			if(data2 == 0)
				System.out.println(0);
			else
				System.out.println(data1/data2);
		}
	}
}