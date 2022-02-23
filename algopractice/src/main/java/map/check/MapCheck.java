package map.check;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.io.CharStreams;

public class MapCheck {

	public static void main(String[] args) {
		Car vw = new Car("Volkswagen");
		Car vw1 = new Car("Volkswagen");

		Car tata = new Car("Tata");
		if (tata == vw)
			System.out.println("Same");
		else
			System.out.println("Not Same");
		Map<Car, Car> m = new HashMap<>();
		m.put(vw, vw);
		vw.brand = "Maruti";
//		vw1.brand = "Maruti";

		m.put(vw1, vw1);
		if (vw == vw1)
			System.out.println("Equility Success");
		else
			System.out.println("Equility Failure");
		if (vw.equals(vw1))
			System.out.println("Equals Success");
		else
			System.out.println("Equals Failure");

			
			m.put(tata, tata);
		System.out.println(m.size());
		System.out.println(m.get(vw));
//		m.keySet().stream().forEach(System.out::println);

		IntStream.range(0, 100).forEach(p -> System.out.print("*"));
		Map<Car, Car> mi = new IdentityHashMap<>();
		mi.put(vw, vw);
		mi.put(vw1, vw1);
		mi.put(tata, tata);
		System.out.println(mi.size());
		mi.keySet().stream().forEach(System.out::println);
	}

}
