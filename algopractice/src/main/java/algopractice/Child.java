package algopractice;

import java.util.TreeMap;

public class Child extends Base {
	
Child(int i) {
//		super(i);
		// TODO Auto-generated constructor stub
	}

//	Child() {
//		System.out.println("Child Constructor");
//	}
//
//	Child(int i) {
//		System.out.println("Child Constructor with int " + i);
//	}
	public static void main(String[] args) {
//		Base b = new Base(2);
		Child c = new Child(1);
		c.somemethod();
	}
	
	public void somemethod() {
		Base b = new Base(2);
		Base c = new Child(3);
		Child d = new Child(3);

//		b.testMethod();
//		c.testMethod();
//		d.testMethod();
//		testMethod();
//		super.testMethod();
		methodWithParam1((Child) b);
		methodWithParam1((Child) c);
		methodWithParam1(d);
		methodWithParam2(b);
		methodWithParam2(c);
		methodWithParam2(d);




	}

	@Override
	protected void testMethod() {
		System.out.println(" Test of Child");
		
		TreeMap<Integer, String> tr = new TreeMap<>();
	}
	
	void methodWithParam1(Child c) {
		c.testMethod();
	}
	
	void methodWithParam2(Base c) {
		c.testMethod();
	}

}
