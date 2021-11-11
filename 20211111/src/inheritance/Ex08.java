package inheritance;

public class Ex08 {
	int first;
	int second;
	int result;
	public Ex08(int first, int second) {
		this.first = first;
		this.second = second;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getFirst() {
		return first;
	}
	public int getSecond() {
		return second;
	}
	public int getResult() {
		return result;
	}
	void div() {
		result = first / second;
	}
	public void add() {
		result = first + second;
	}
	
}