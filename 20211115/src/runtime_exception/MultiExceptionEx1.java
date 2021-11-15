package runtime_exception;

public class MultiExceptionEx1 {
	public static void main(String[] args) {
		int data1 = 0;
		int data2 = 0;
		try {
			data1 = Integer.parseInt(args[0]);
			data2 = Integer.parseInt(args[1]);
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data1 / data2);
		}catch(Exception e) {
			System.out.println("입력값이 2개이어야 합니다.");
			if(data2 == 0)
				System.out.println(0);
			else
				System.out.println(data1/data2);
		}
		
	}
}
