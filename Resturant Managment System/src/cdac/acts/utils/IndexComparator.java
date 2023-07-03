package cdac.acts.utils;

import java.util.Comparator;

import cdac.acts.com.Dish;

public class IndexComparator implements Comparator<Dish> {

	public int compare(Dish d1, Dish d2) {

		return d1.getIndex() - d2.getIndex();
	}

}
