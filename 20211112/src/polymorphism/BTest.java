package polymorphism;

public class BTest {

	public static void main(String[] args) {
		B b = new B();
		A a = b;
		a.method0();
		A a1 = new A();
		a1.method0();

	}

}
