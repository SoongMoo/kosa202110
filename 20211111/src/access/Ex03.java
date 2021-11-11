package access;

import access.access1.Ex04;

/// 다른 패키지에 있는 클래스에서 
/// protected멤버는 상속이 된다. 
// default 멤버는 상속되지 않지만 
public class Ex03 extends Ex04{
	public void sub() {
		result = first - second;
	}
	public void div() {
		result = first / second;
	}
}
