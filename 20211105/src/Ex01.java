
public class Ex01 {
	public static void main(String [] args) {
		/// 리터널 : 자연어 : 한국어, 영어,... / 자연수 : 정수 , 실수
		/* 자료형 : 정수 : byte(1),char(2), short(2),int(4),long(8)
		 *        실수 : float(4), double(8)
		 *        문자 : char(2) : 'a', '가'
		 *        문자열 : String : "abc", "가니", "a", "가"
		 */
		// 형변환 : 자동형변환, 강제형변환
		short sh = 10;
		int i = sh; // 자동형변환
		sh = (short)i; // 강제형변환
		short sh1 = 10;
		short sh2 = 20;
		// short sh3 = sh1 + sh2;
		int i1 = sh1 + sh2;
		short sh4 = (short)(sh1 + sh2);
		//short sh5 = (short)sh1 + (short)sh2;
		//            4byte => 2byte => 4byte
		//                강제형변환  자동형변환
		// byte => char => short => int => long => float => double
		//  위 방향으로는 언제든 자동형변환이 일어난다.
		
		// 제어문 : 조건문 , 반복문
		// if , if ~ else , if ~ else if ~ else if ~ ... ~ else
		// switch ~ case
		int money = 3000;
		if (money >= 3000) {
			System.out.println(" 차를 타고 가시오. ");
		}
		if (money >= 3000) {
			System.out.println(" 차를 타고 가시오. ");
		}else {
			System.out.println(" 걸어가시오. ");
		}
	}
}




