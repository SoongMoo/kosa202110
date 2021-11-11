
public class Singleton {
	int first;
	int second;
    static    int       val    =     10;
	// 자기 자신의 객체를 미리 만들어 놓고 사용
    private static Singleton singleton = new Singleton(); /// 30000
	private Singleton() {}
	public static Singleton getInstance() {// 자신의 객체를 전달
		return singleton;
	}

	
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
}
