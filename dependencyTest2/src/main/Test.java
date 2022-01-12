package main;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
		NumberCalss num = new NumberCalss();
		num.setI(1);
		System.out.print("1 : ");
		System.out.println(num.getI());
		NumberCalss num1 = new NumberCalss(10, 20);
		System.out.print("2 : ");
		System.out.println(num1.getI());
		NumberCalss num2 = new NumberCalss(new Test1());
		System.out.print("3 : ");
		num2.print();
		System.out.print("4 : ");
		//num.setTt(new Test1());
		//num.print();
		num.setDate(new Date());
		num.datePrint();
	}
}
