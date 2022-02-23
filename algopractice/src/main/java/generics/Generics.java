package generics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class Generics {

	public static void main(String[] args) {
		Farm f = new Farm();
		List<Dog> l = new ArrayList<>();
		Map m = new HashMap();
		ForkJoinPool pool = ForkJoinPool.commonPool(); 
//		CopyOnWriteArrayList<K, V>
		m.entrySet();
		l.add(new Dog("tmo"));
		f.addAnimals(l);
		
		List<Object> l1 = new ArrayList<Object>();
		f.addDogs(l1);
		

	}

}
