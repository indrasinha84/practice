import java.util.HashMap;
import java.util.Map;

public class B extends A {
	int c = 3;
	Integer b;

	public void print() {
		System.out.println("BB");
		b = 6;
//		System.out.println(b);
//		System.out.println(c);

	}

	public static void main(String[] args) {
		A a = new B();
		a.print();
		Map m = new HashMap();
		System.out.println(a.c);
		System.out.println(a.b);
	}
}