package constructor.check;

public class BaseConstuctor {

//	BaseConstuctor() {
//		System.out.println("BaseConstuctor" );
//
//	}

	static int a = 3;

	BaseConstuctor(int a) {
		
		System.out.println("BaseConstuctor" + a );

	}

	public static void main(String[] args) {
		BaseConstuctor bc = new BaseConstuctor(1);
	}
}
