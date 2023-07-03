package cdac.acts.com;

import java.util.Objects;

public class Dish implements Comparable<Dish> {

	private String dishName;
	private float price;
	private int index;

		@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		return index == other.index;
	}

	public Dish() {
	}

	public Dish(int index, String dishName, float price) {
		super();
		this.dishName = dishName;
		this.price = price;
		this.index = index;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int compareTo(Dish other) {
		return (int) (this.price - other.price);
	}

	@Override
	public String toString() {
		return String.format("  %-8d%-20s%-2.2f", index, dishName, price);
	}

}
