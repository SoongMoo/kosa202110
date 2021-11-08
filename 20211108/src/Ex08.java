
public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i0 = 1;
		int i1 = 2;
		int i2 = 3;
		int i3 = 4;
		int i[] = {1,2,3,4}; // 배열 / 1차원배열
		//         0 1 2 3
		System.out.println(i0); // i[0]
		int ii[] = {10,20,30,40};
		int iii[] = {11,22,33,44};
		
		int y[][] = new int [3][];
//		y[3][]
//			i[]   = 1 , 2, 3, 4 : y[0]
//		    ii[]  = 10,20,30,40 : y[1]
//		    iii[] = 11,22,33,44 : y[2]
		y[0] = i;
		y[1] = ii;
		y[2] = iii;
		System.out.println(i[0]);
		System.out.println(y[0][0]);
		System.out.println(ii[0]);
		System.out.println(y[1][0]);
		System.out.println(iii[0]);
		System.out.println(y[2][0]);
	

	}

}
