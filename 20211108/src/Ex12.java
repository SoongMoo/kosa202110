
public class Ex12 {

	public static void main(String[] args) {
		// For Each :for문 확장
		int [] i = {1,2,3,4,5};
		int sum = 0;
		/// 합계를 구하시오,
		for(int j = 0; j < i.length ; j++) {
			sum += i[j];
		}
		System.out.println(sum);
		System.out.println("===============================");
		sum =0; // 배열의 크기 만큼만 반복
		for(int k : i) { // k = i[0], k = i[1], k = i[2],...,k = i[4]
			sum += k;
		}
		System.out.println(sum);
		System.out.println("==============================");
		int ii[][] = {{1,2,3,4},{5,6},{7,8,9,10,11}};
		sum = 0;
		for(int row = 0; row<ii.length; row++) {
			for(int col =0 ; col <ii[row].length; col++) {
				sum += ii[row][col];
			}
		}
		System.out.println(sum);
		System.out.println("=============================");
		for(int [] row : ii) { // row=ii[0],
			for(int col : row) {// col=ii[0][0],col=ii[0][1],col=ii[0][2],col=ii[0][3],
				sum += col;     // row=ii[1]
			}                   // col=ii[1][0],col=ii[1][1]
		}                       // row=ii[2] 
		System.out.println(sum);// col=ii[2][0],col=ii[2][1],...,col=ii[2][4]
	}

}
