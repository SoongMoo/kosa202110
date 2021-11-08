
public class Ex02 {

	public static void main(String[] args) {
		// 배열 선언법
		// []연산자 : 배열로 선언하기 위한 연산자.
		int j = 10+15;
		int i [] = {10,20,30};
		int i1 [];// 배열 선언
		i1 = new int [] {10,20,30}; // 배열 생성, 크기가 정해져야 함.
		int i2 [] = new int[3]; // 배열의 크기 3이다.
		i2[0] = 10;
		i2[1] = 20;
		i2[2] = 30; // 3개의 값만 저장
		int i3[];
		i3 = new int[3]; // 배열의 크기 3으로 함
		                //        0    1    2
		i3[0] = 10;     // i3 = | 10 |    |    |
		i3[1] = 20;     // i3 = | 10 | 20 |    |       
		i3[2] = 30;     // i3 = | 10 | 20 | 30 |        
		// 3개의 값만 저장
		System.out.println(i3[2]);
		/* 사용 불가
		int i4 [];
		i4 = {10,20,30}; 
		*/
		int i5[];       //       0    1   2
		i5 = new int[3];// i5 = | 0 | 0 | 0 |
		// 배열을 만들게 되면 각요소는 0으로 초기화가 된다.
		System.out.println(i5[0]); 
		System.out.println(i5[1]);
		System.out.println(i5[2]);
		int y; // 변수는 0으로 초기화 되어 있지 않다.
		// System.out.println(y);// 초기화가 되지 않아 오류		
	}
}
