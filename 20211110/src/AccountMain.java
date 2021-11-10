import java.util.Scanner;
public class AccountMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		Account acc= new Account("1111","이숭무",100);
		Account acc1= new Account("2222","이상범",100);
		Account acc2= new Account("3333","이장범",100);
		*/
		int arrayNum = 0; // 배열의 현재 번호 가지기 위한 변수
		Account [] accs = new Account[100];
		// 배열의 index는 0번 부터 시작
		boolean run = true;
		// while(run) {
		do {	
			System.out.println("1. 계좌등록 | 2. 계좌 목록 "
					+ "| 3. 예금 | 4. 출금 | 5. 종료");
			System.out.print("선택 > ");
			int selecNo = sc.nextInt(); // 123456\n
			sc.nextLine(); // 입력장치에 \n값이 있는 것을 없애기 위해 사용
			switch(selecNo) {
			case 1 : 
				System.out.println("계좌등록 페이지입니다.");
				System.out.print("계좌 번호 : ");
				String accountNo = sc.nextLine();
				System.out.print("예금주 : ");
				String owner = sc.nextLine();
				System.out.print("금액 : ");
				int money = sc.nextInt();
				accs[arrayNum] = new Account(accountNo,owner, money);
				arrayNum++;
				System.out.println("계좌등록이 완료되었습니다.\n");
				break;
			case 2 :
				System.out.println("계좌목록 페이지입니다.");
				System.out.println("계좌 번호 \t\t 계좌주 \t\t 금액");
				for(int i = 0 ; i < accs.length; i++) {
					if(accs[i] == null) break;
					System.out.println(accs[i].getAccountNo()+"\t\t"
							+accs[i].getOwner()+"\t\t"
							+accs[i].getBalance());
				}
				System.out.println();
				break;
			case 3 :
				System.out.println("예금 페이지입니다.");
				System.out.print("계좌번호  : ");
				accountNo = sc.nextLine();
				System.out.println("예금액 : ");
				money = Integer.parseInt(sc.nextLine());
				Account acc = null;
				for(int i = 0 ; i < accs.length; i++) {
					if (accs[i] == null ) break;
					else {
						if(accs[i].getAccountNo().equals(accountNo)) {
					// 계좌번호가 일치하는 Account를 가지고 와서 acc에저장
							acc = accs[i];
							// acc = accs[0], acc = accs[1],...
							break;
						}
					}
				}
				int result = acc.getBalance() + money;
				acc.setBalance(result);
				System.out.println();
				break;
			case 4 :
				System.out.println("출금 페이지입니다.");
				System.out.print("계좌번호  : ");
				accountNo = sc.nextLine();
				System.out.println("예금액 : ");
				money = Integer.parseInt(sc.nextLine());
				acc = null;
				for(int i = 0 ; i < accs.length; i++) {
					if (accs[i] == null ) break;
					else {
						if(accs[i].getAccountNo().equals(accountNo)) {
					// 계좌번호가 일치하는 Account를 가지고 와서 acc에저장
							acc = accs[i];
							// acc = accs[0], acc = accs[1],...
							break;
						}
					}
				}
				result = acc.getBalance() - money;
				acc.setBalance(result);
				break;
			case 5 :
				System.out.println("프로그램이 종료되었습니다.");
				run = false; break;
				//System.exit(0); //프로그램 종료
			}
		}while(run);
		//}
	}
}







