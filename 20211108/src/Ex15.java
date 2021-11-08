
public class Ex15 {

	public static void main(String[] args) {
		WEEK1 today = WEEK1.토요일;
		System.out.println(today); // 열거형 상수
		String name = today.name(); //열거형 상수를 문자열로 형변환
		System.out.println(name); // 문자열
		
		// 열거형 상수가 가지고 있는 정수값을 가지고 오기
		int ordinal = today.ordinal();
		System.out.println(ordinal);
		
		WEEK1 day1 = WEEK1.목요일;
		WEEK1 day2= WEEK1.화요일;
		
		int result = day1.compareTo(day2);
		System.out.println(result); // 2일 지났습니다. 2
		result = day2.compareTo(day1);
		System.out.println(result); // 2일 전입니다. -2
		
		// 문자열을 열거형으로 변환
		String day = "수요일";
		WEEK1 weekDay = WEEK1.valueOf(day);
		System.out.println(weekDay); // 열거형 출력
		// 열거형에 있는 모든 상수를 가져오기
		
		WEEK1 day3 = WEEK1.금요일;
		// 열거형 변수에는 열거형 상수 하나만 저장된다.
		WEEK1 [] days = WEEK1.values();// 열거형 상수를 배열로 반환
		for(WEEK1 w : days ) {
			System.out.println(w);
		}
	}
}
