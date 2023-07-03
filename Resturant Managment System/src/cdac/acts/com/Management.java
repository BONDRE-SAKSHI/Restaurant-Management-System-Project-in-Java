package cdac.acts.com;

import java.util.*;
import cdac.acts.com.*;
import java.util.Comparator.*;
import cdac.acts.utils.*;
import cdac.acts.thread.*;

public class Management {
	static int i11 = 10;
	private static int choice;
	static Tester test = new Tester();

	public static Dish[] getDish() {
		Dish[] d = new Dish[10];
		d[0] = new Dish(0, "Pasta", 100.0f);
		d[1] = new Dish(1, "Momos", 200.0f);
		d[2] = new Dish(2, "Brownie", 150.0f);
		d[3] = new Dish(3, "Dosa", 145.0f);
		d[4] = new Dish(4, "Pav Bhaji", 165.0f);
		d[5] = new Dish(5, "Roll", 100.0f);
		d[6] = new Dish(6, "Noodles", 150.0f);
		d[7] = new Dish(7, "Fried Rice", 200.0f);
		d[8] = new Dish(8, "idli", 30.0f);
		d[9] = new Dish(9, "Red sauce Pasta", 350.0f);
		return d;

	}

	private static Scanner sc = new Scanner(System.in);

	enum Menu {
		EXIT, VIEW, ADD, REMOVE, MODIFY, COMPARE
	}

	public static Menu menuList() {
		System.out.println("0. Exit the program");
		System.out.println("1. View the current menu with prices");
		System.out.println("2. Add a new dish to the menu");
		System.out.println("3. Remove a dish from the menu");
		System.out.println("4. Modify the price of a dish on the menu");
		System.out.println("5. Sort The Menulist ");
		System.out.println();

		System.out.println("Enter your choice");
		System.out.println("----------------------------------------");
		TimerEffect.loadEffect("LOADING TO");
		return Menu.values()[sc.nextInt()];
	}

	enum SubMenu {
		EXIT, IndexComparator, NameComparator, PriceComparator
	}

	public static SubMenu subMenuList() {
		System.out.println("0.Exit");
		System.out.println("1.Compare By index");
		System.out.println("2.Compare By name");
		System.out.println("3.Compare By price");
		System.out.println("----------------------------------------");
		TimerEffect.loadEffect("   LOADING TO");
		System.out.println();
		System.out.print("Enter choice	:	");
		return SubMenu.values()[sc.nextInt()];
	}

	public static void SwitchMenu() {
		Menu choice;
		while (true) {
			try {
				choice = menuList();
				if (choice == Menu.EXIT) {
					break;
				}
				switch (choice) {
				case VIEW:
					TimerEffect.loadEffect(" ","#");
					// Dish[] d = Management.getDish( );
					// Tester.addDishes( d );
					Tester.printDishes();
					break;
				case ADD:
					TimerEffect.loadEffect(" ","#");
					Tester.AddDish((Dish) dishcreateRecord());
					break;
				case REMOVE:
					TimerEffect.loadEffect(" ","#");
					try {
					System.out.println("Entr INDEX from which u want to REMOVE the dish : ");
					Tester.removeDish(sc.nextInt());
					}catch (IndexOutOfBoundsException e) {
						sc.nextLine();
						System.err.println("INVALID INPUT");
						sc.nextLine();
					}
					
					break;
				case MODIFY:
					TimerEffect.loadEffect(" ","#");
					System.out.println("Entr INDEX from which u want to MODIFY the dish PRICE : ");
					int id = sc.nextInt();
					Dish dish = Tester.findDish(id);
					if (dish != null) {
						Tester.modifyMenu(dish);
					} else
						System.err.println("DISH NOT FOUND....!!!");
					// d[i].getPrice();
					// System.out.println(Tester.modifyMenu(sc.nextInt()));

					break;

				case COMPARE:
					TimerEffect.loadEffect(" ","#");
					SubMenu ch;
					while (true) {
						Comparator<Dish> comparator = null;
						try {
							ch = subMenuList();
							if (ch == SubMenu.EXIT) {
								break;
							}
							switch (ch) {
							case IndexComparator:
								comparator = new IndexComparator();
								break;
							case NameComparator:
								comparator = new NameComparator();
								break;
							case PriceComparator:
								comparator = new PriceComparator();
								break;
							
							}
							Tester.printDishes(comparator);

						} catch (InputMismatchException e) {
							System.err.println("INVALID INPUT");
							System.err.println();
						}
						
					}
					
				
				}
				System.out.println("####################################");
				System.out.println("THANK YOU .....!!!");
				System.out.println("####################################");
				System.out.println();
				System.out.println();
			}

			catch (InputMismatchException e) {
				System.err.println("INVALID INPUT");
			}

		}
	}

	private static Object dishcreateRecord() {
		Dish dish = new Dish();
		sc.nextLine();
		// static int i1=11;
		dish.setIndex(i11);
		i11++;
		System.out.println("Enter name of the DISH : ");
		// dish.setDishName(sc.nextLine());
		dish.setDishName(sc.nextLine());
		
		System.out.println("Enter price of the DISH : ");
		// dish.setPrice(sc.nextFloat());
		dish.setPrice(sc.nextFloat());
		return dish;
	}

}
