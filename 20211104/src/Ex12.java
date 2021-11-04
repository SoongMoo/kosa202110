
public class Ex12 {
	public static void main(String[] args) {
		// if ~ else
		int money = 2000;
		if (money >= 3000) { // true
			System.out.println("차를 타고가시오.");
		}else { // false
			System.out.println("걸어가시오.");
		}	
		/* if money >= 3000 :
		 * 		print("차를 타고 가시오")
		 * else:
		 * 		print("걸어가시오. ")
		 */
		char gender = 'M';
		if (gender == 'M') 
			System.out.println("남자입니다.");
		else 
			System.out.println("여자입니다.");
		
		int score = 57;
		if (score >= 60) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
	}
}






