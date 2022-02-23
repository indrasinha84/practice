package constructor.check;

public class ChildConstructor extends BaseConstuctor {

	ChildConstructor() {
		
		super(1);
		System.out.println("ChildConstructor");
	}

	ChildConstructor(int a) {
		super(a);
//		super(a);
		System.out.println("ChildConstructor" + a);

	}

	public static void main(String[] args) {
		ChildConstructor cc = new ChildConstructor(2);
//		BaseConstuctor bc = new BaseConstuctor(1);
		System.out.println(BaseConstuctor.a);
	}

}
