package main;

import java.util.Date;

public class NumberCalss {
	private int i;
	private int j;
	Test1 tt; // Test1 tt = new Test1();
	Date date;
	public NumberCalss() {}
	public NumberCalss(int i, int j) {
		this.i = i;
		this.j = j;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void datePrint() {
		System.out.println(date.getDate());
	}
	public void print() {
		System.out.println(tt.getX());
	}
	public NumberCalss(Test1 tt) { // Test1 tt = new Test1();
		this.tt = tt;
	}
	public void setTt(Test1 tt) {
		this.tt = tt;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getI() {
		return  i;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public int getJ() {
		return j;
	}
}
