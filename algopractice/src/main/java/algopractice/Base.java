package algopractice;

import java.util.TreeMap;

public class Base {
	protected Base() {
		System.out.println("Parent Constructor");
	}

	protected Base(int i) {
		System.out.println("Parent Constructor with int " + i);
	}

	protected void testMethod() {
		System.out.println(" Test");
		
		TreeMap<Integer, String> tr = new TreeMap<>();
	}

}
