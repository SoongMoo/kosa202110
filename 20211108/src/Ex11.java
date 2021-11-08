
public class Ex11 {

	public static void main(String[] args) {
		// 4행 5열짜리 배열을 만들어서 Math.random()을 이용하여 값을 저장하시오.
		// 랜덤은 1~100까지의 수
		int i [][] = new int[4][5];
		int row = 0;
		while (row <i.length) {
			int col = 0;
			while(col < i[row].length) {
				i[row][col]= (int)(Math.random() * 100) + 1;
				col++;
			}
			row++;
		}
		////////////////////////////////////////////////////
		for(row = 0; row < i.length; row++) {
			for(int col = 0; col < i[row].length; col++) {
				System.out.println("i["+row+"]["+col+"]="+i[row][col]);
			}
		}
	}

}
