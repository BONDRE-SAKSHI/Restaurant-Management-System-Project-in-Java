package cdac.acts.utils;

import java.util.Comparator;
import cdac.acts.com.Dish;

public class PriceComparator implements Comparator<Dish> {
	
	public int compare(Dish d1, Dish d2) {
	
		return (int) (d1.getPrice() - d2.getPrice());
	
	}
}
