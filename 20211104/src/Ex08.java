
public class Ex08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = -128;
		System.out.println(-i);
		int i1 = 1;
		i1 = i1 + 1; // i1 = 1 + 1 : 1증가
		System.out.println(i1);
		i1 = i1 + 1;
		System.out.println(i1);
		++i1; // i1 = i1 + 1 : 선행연산
		System.out.println(i1);
		i1++; // i1 = i1 +1  : 후행연산
		System.out.println(i1);
		int y = ++i1; // i1 = i1 + 1; y = i1;
		              // i1 = 5 + 1  ; y  = 6
		System.out.println(y);
		System.out.println(i1);
		y = i1++; // y = i1; i1 = i1 + 1 : 후행
		System.out.println(y); // 6
		System.out.println(i1); // 7
		int i2 = 10;
		i2 = i2 - 1; // 1감소
		System.out.println(i2);
		i2 = i2 - 1; // 1감소
		System.out.println(i2);
		--i2; // i2 = i2 - 1 : 선행연산
		System.out.println(i2);
		i2--;                // 후행 연산
		System.out.println(i2);
		y = --i2; // i2 = i2 -1 ; y = i2
		System.out.println(y);
		System.out.println(i2);
		y = i2--; //  y = i2; i2 = i2 -1
		System.out.println(y);
		System.out.println(i2);
		
		i1 = 10;
		System.out.println(++i1); // 선행 11
		System.out.println(i1); // 11
		
		i1 = 10;
		System.out.println(i1++); // 10
		/* System.out.println(i1);
		 * i1 = i1 + 1
		 */
		System.out.println(i1); // 11
		
		
		int i3 = 10;
		int j = 20;
		int z = ++i3 + j++;
		// i3 = i3 + 1 = 11
		// z = 11 + 20 = 31
		// j = j + 1 = 21
		System.out.println("z =" + z);
		System.out.println("i3= " + i3);
		System.out.println("j= " + j);
		// 증가감 : ++, --
	}
}







