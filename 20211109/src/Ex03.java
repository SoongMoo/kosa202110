
public class Ex03 {
	int first; // ¸â¹ö ÇÊµå
	int second;
	int result;
	public void setData(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public void setSecond(int second) {
		this.second = second;
	}// setter
	public int getFirst() {
		return this.first;
	}// getter
	public int getSecond() {
		return this.second;
	}
	public void add() {
		this.result = this.first + this.second;
	}
	public void sub() {
		this.result = this.first - this.second;
	}
}
