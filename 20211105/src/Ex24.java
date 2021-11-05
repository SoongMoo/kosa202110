import java.util.Scanner;

public class Ex24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stop;
		do{
			System.out.print("시작 단을 입력해 주세요. :");
			int startDan = sc.nextInt();
			System.out.print("마지막 단을 입력해 주세요. :");
			int endDan = sc.nextInt();
			System.out.print("시작 곱을 입력해 주세요. :");
			int startGop = sc.nextInt();
			System.out.print("마지막 곱을 입력해 주세요. :");
			int endGop = sc.nextInt();
			
			int dan = startDan;
			while (dan <= endDan) {
				int gop = startGop;
				while (gop <= endGop) {
					System.out.println(dan + "*" + gop +"="+dan*gop);
					gop++;
				}
				dan++;
			}
			System.out.println("종료하려면 'y'아니면 아무키나. : ");
			stop = sc.next();
		}while(!stop.equals("y"));
	}
}