package cdac.acts.com;

import java.util.*;
import cdac.acts.com.*;

public class Tester {
	private static Scanner sc = new Scanner(System.in);
	private static List<Dish> DishList;
	static Dish[] d = Management.getDish();
	private static List<Dish> CoustomerList;
	private static int[] Rate = new int[50];
	private static boolean[][] arr = new boolean[10][10];
	public static int quantity = 0;

	public List<Dish> getCoustomerList() {
		return CoustomerList;
	}

	public void setCoustomerList(List<Dish> coustomerList) {
		CoustomerList = coustomerList;
	}

	public static void printDishes() {

		Dish dish = new Dish();
		System.out.println("####################################");
		System.out.println("####################################");
		System.out.println("####       Resturant Menu       ####");
		System.out.println("####################################");
		System.out.println("####################################");

		System.out.println("___________________________________");
		System.out.println("INDEX      MENU                PRICE    ");
		System.out.println("___________________________________");

		DishList.forEach(System.out::println);

		System.out.println("___________________________________");
		System.out.println("___________________________________");

	}

	public static void printArray2() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				// arr[i][j]=false;
				System.out.print(String.format("%-7b", arr[i][j]));
			}
			System.out.println();
		}
	}

	public static void BookTable() {
		System.out.println("Enter row of table to book ");
		int i = sc.nextInt();
		System.out.println("Enter column of table to book");
		int j = sc.nextInt();
		if (i < 10 && i >= 0 && j < 10 && j >= 0 && (arr[i][j] == false)) {
			arr[i][j] = true;
			System.out.println("Your Table is Booked at ----->>> ");
			printArray2();
		} else {
			System.out.println("Invalid input Table not found");
		}
	}

	public static void AddDish(Dish dish) {
		// System.out.println(dish);
		// int c=10;
		if (dish != null) {

			DishList.add(dish);
		}
		System.out.println("Your Dish Added Successfully ");
	}

	public static void removeDish(int i) {
		Dish d = new Dish();
		d.setIndex(i);
		// if(DishList.contains(d)) {
		// d.setIndex(i);
		DishList.remove(i);
		System.out.println("Dish removed");
	}

	private static boolean isInvalidData(int i) {
		if (i < 0 || i >= d.length) {
			System.out.println("INVALID INPUT");
			return true;
		}
		if (d[i] == null) {
			System.out.println("Dishes Added Successfully" + i);
			return true;
		}
		return false;
	}

	public static Dish findDish(int id) {

		if (DishList != null) {
			Dish dish = new Dish();
			dish.setIndex(id);
			if (DishList.contains(dish)) {
				int index = DishList.indexOf(dish);
				Dish value = DishList.get(index);

				return value;
			}
		}
		return null;
	}

	public static void modifyMenu(Dish dish) {
		/*
		 * //System.out.println(i); Dish d1=new Dish(); //i=i-1; DishList.add(d1);
		 * System.out.println("Enter New Price"); d1.setPrice(sc.nextFloat());
		 * System.out.println("Price Modified ");
		 * //System.out.println("Price Modified to "+value);
		 */
		// if (isInvalidData(i)) return ;
		System.out.println("Enter the Modified price for " + dish.getDishName());
		System.out.println("Current price for " + dish.getPrice());
		System.out.println("Enter the price to change :");
		dish.setPrice(sc.nextFloat());

	}

	public static void OrderDish(Object dd) {
		System.out.println(dd);
		if (dd != null) {
			Dish d = new Dish();
			d.setIndex((int) dd);
			
			// System.out.println(DishList.get((int)dd));
			CoustomerList.add(DishList.get((int) dd));
			// System.out.println(CoustomerList);
			System.out.println("Enter Quantity ");
			quantity = sc.nextInt();
			System.out.println("Thank u for your Order ");
			System.out.println();
			System.out.println("Order Placed Successfully");
			System.out.println();
			System.out.println("You want to Order more  ");
		} else {
			System.err.println("Invalid number");
		}
	}

	/*
	 * public static void PrintBill() { for(Dish d : CoustomerList )
	 * System.out.println (" name  : "+d.getDishName() + " Price : "+d.getPrice()
	 * +" * "+" Quantity : "+quantity +"\n\n Total Bill : " +d.getPrice()*quantity
	 * ); System.out.println();
	 * 
	 * }
	 */
	static float p = 0.0f;

	public static void PrintBill() {
		for (Dish d : CoustomerList) {
			System.out.println(
					" name  : " + d.getDishName() + " Price : " + d.getPrice() + " * " + " Quantity : " + quantity
			/* +"\n\n Total Bill : " +d.getPrice()*quantity */);
			System.out.println();
			p = p + d.getPrice() * quantity;
		}
		System.out.println("___________________________________");
		System.out.println("___________________________________");
		System.out.println("Total Bill : " + p);
		System.out.println("___________________________________");
		System.out.println("___________________________________");
	}

	public static void addDishes(Dish[] d) {
		if (DishList != null) {
			if (d != null) {
				for (Dish dish : d)
					DishList.add(dish);
				System.out.println("");
				//System.out.println("Dishes Added Successfully");
				return ;
			}
		}System.err.println("Invalid Input");

	}

	public static void viewOrder() {
		CoustomerList.forEach(System.out::println); // lambda expressions
	}

	public static void cancelOrder() {
		sc.nextInt();
		System.out.println("Do u want to cancel whole order True/false");
		boolean i = sc.nextBoolean();
		if (i) {
			CoustomerList.removeAll(CoustomerList);

			System.out.println("Your Order is cancelled Successfully");
		} else {

			System.out.println("Enter Index of dish u dont want");
			int j = sc.nextInt();
			CoustomerList.remove(j);
		}
		System.out.println("Thank You For Being With Us");
		System.out.println("____________________________");

	}

	public static void setDishList(List<Dish> dishList) {
		DishList = dishList;
	}

	static int r = 0;
	static int count = 0;

	public static void Rating() {
		System.out.println("Rate US From(1-5) Stars");
		int k = sc.nextInt();
		// int k=Rate[r];
		if (k >= 0 && k <= 5) {
			Rate[r] = k;
			count++;
			Tester.OverallRating();
			r++;
		} else {
			System.out.println("Invalid");
		}
	}

	public static void OverallRating() {
		int sum = 0;
		int l = 0;
		for (int i = 0; i < count; i++) {
			if (Rate[r] != 0) {
				sum = sum + Rate[i];
				l++;
				// System.out.println(sum);
			} else
				break;
		}
		if (l != 0) {
			sum = sum / l;
			System.out.println("OverAll Rating: " + sum);
		} else {
			System.out.println("Not Rated Yet");
		}
	}

	public static void printDishes(Comparator<Dish> comparator) {
		Tester.DishList.sort(comparator);
		Tester.DishList.forEach(System.out::println);
	}
}
