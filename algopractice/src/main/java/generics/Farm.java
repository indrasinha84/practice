package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Farm {
	public Farm() {

	}

	private List<Animal> animals = new ArrayList<>();

	public void addAnimals(List<? extends Animal> newAnimals) {
		animals.addAll(newAnimals);
	}

	public void addDogs(List<? super Animal> list) {
		animals.addAll((List<? extends Animal>) list);
	}

}
