
public class Ex04 {

	public static void main(String[] args) {
		int num = (int)(Math.random() * 6) + 1;
		System.out.println(num);
		if (num == 1 || num == 4) {
			System.out.println('A');
		}else if(num == 2 || num == 5) {
			System.out.println('B');
		}else if(num == 3 || num == 6) {
			System.out.println('C');
		}
		System.out.println("=== swith ====");	
		num = 1;
		switch(num) {
		case 1 : 
		case 4 : System.out.println('A');break;
		case 2 : 
		case 5 : System.out.println('B'); break;
		case 3 : 
		case 6 : System.out.println('C'); break;
		}
	}
}