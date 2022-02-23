import java.util.ArrayList;
import java.util.List;

public class SingleTon {

	private SingleTon() {
	}

	public static void main(String[] args) {
	List<String> l = new ArrayList();

		SingleTon st = SingleTon.getInstance();
		System.out.println(st);
	}

	private static class SingleTonHelper {
		private static SingleTon INSTANCE = new SingleTon();

	}

	private static SingleTon getInstance() {
		return SingleTonHelper.INSTANCE;
	}

	protected Object readResolve() {
		return getInstance();
	}
}
