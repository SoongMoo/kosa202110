
public class Ex10 {

	public static void main(String[] args) {
		// 2 차원 배열 선언법
		//           0 1 2 3
		int [] i0 = {1,2,3,4};      // i[0]
		          // 0 1 2
		int [] i1 = {5,6,7};        // i[1]
		          // 0 1  2  3  4 
		int [] i2 = {8,9,10,11,12}; // i[2]
		int [][] i = new int[3][];
		i[0] = i0;
		i[1] = i1;
		i[2] = i2;
		// System.out.println(i[1][3]);
		System.out.println(i[2][4]);
		int [][] ii = new int[3][];
		ii[0] = new int[4];
		ii[1] = new int[3];
		ii[2] = new int[5];
		ii[0][0]=1;ii[0][1]=2;ii[0][2]=3;ii[0][3]=4;
		ii[1][0]=5;ii[1][1]=6;ii[1][2]=7;
		ii[2][0]=8;ii[2][1]=9;ii[2][2]=10;ii[2][3]=11;ii[2][4]=12;
		System.out.println("=====================");
		int [][] iii = new int[3][4];
		iii[0][0]=1;iii[0][1]=2;iii[0][2]=3;iii[0][3]=4;
		iii[1][0]=5;iii[1][1]=6;iii[1][2]=7;iii[1][3]=8;
		iii[2][0]=9;iii[2][1]=10;iii[2][2]=11;iii[2][3]=12;
		System.out.println("=====================");
		int i3[] = new int[3];
		int i4[] = {1,2,3,4};
		System.out.println("=====================");
		int iiii[][]= {{1,2,3,4},{5,6,7},{8,9,10,11,12}};
		System.out.println(iiii[2][4]);
//		// iiii.length // 2차원배열의 크기 : 3
//		iiii[][]                      // 1차원 배열의 크기
//				iiii[0] 1,2,3,4       // iiii[0].length : 4
//				iiii[1] 5,6,7         // iiii[1].length : 3
//				iiii[2] 8,9,10,11,12  // iiii[2].length : 5
		/// iiii의 배열의 값을 요소번호와 같이 출력하시오. iiii[0][1] = 2
		for(int j = 0; j < iiii.length ; j++) {
			for(int k = 0; k < iiii[j].length   ;k++) {
				System.out.println("iiii["+j+"]["+k+"]="+iiii[j][k]);
			}
		}
	}
}
