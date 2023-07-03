package cdac.acts.utils;

import java.util.Comparator;

import cdac.acts.com.Dish;

public class NameComparator implements Comparator<Dish> {
	
	public int compare(Dish d1, Dish d2) {
		
		return d1.getDishName().compareTo(d2.getDishName());
	
	}

}
