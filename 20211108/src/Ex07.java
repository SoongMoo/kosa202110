
public class Ex07 {

	public static void main(String[] args) {
		int i []  = {1,2,3,4,5}; // 1차원 배열
		System.out.println(i[0]);
		System.out.println(i[1]);
		System.out.println(i[2]);
		System.out.println(i[3]);
		System.out.println(i[4]);
		int i1 []  = {10,20,30,40,50}; // 1차원 배열 
		System.out.println(i1[0]);
		System.out.println(i1[1]);
		System.out.println(i1[2]);
		System.out.println(i1[3]);
		System.out.println(i1[4]);
		// 1차원 배열은 변수 여러개를 하나로 묶어서 사용하려고 
		int j = 1; // i[0]
		int k = 2; // i[1]
		int l = 3; // i[2]
		int m = 4; // i[3]
		int n = 5; // i[4]
		// 크기가 같은 1차원 배열이 여러개가 필요하다면 하나로 묶어서 사용하자.
		int i2 []  = {11,22,33,44,55};
		int ii[][] = new int[3][];
		// 여러개의 1차원배열을 묶으면 2차원이 된다.
//		y [3][]  0    1   2   3   4
//			i = { 1 , 2 , 3 , 4 , 5 } // y[0] 
//			i1 = {10, 20, 30, 40, 30} // y[1]
//			i2 = {11, 22, 33, 44, 55} // y[2]
		// i[0] = y[0][0] // 2차원 배열
	}

}
