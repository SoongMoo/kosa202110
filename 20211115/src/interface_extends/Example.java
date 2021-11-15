package interface_extends;

public class Example {
	public static void main(String[] args) {
		ImplementationC impl = new ImplementationC();
		interfaceA ia = impl;
		ia.methodA();
		interfaceB ib = impl;
		ib.methodB();
		InterfaceC ic = impl;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}