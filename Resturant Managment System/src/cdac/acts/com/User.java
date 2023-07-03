package cdac.acts.com;

import java.util.*;
import cdac.acts.thread.*;

public class User {
	private int quantity;

	public User(int quantity) {
		// super();
		this.quantity = quantity;
	}

	public User() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private static Scanner sc = new Scanner(System.in);

	enum MenuOrder {
		EXIT, VIEW, BOOK_TABLE, ORDER_MENU, CANCEL_ORDER, PRINT_BILL, RATING;
	}

	public static MenuOrder menuList() {
		System.out.println("0 : Exit the program");
		System.out.println("1 : View the current menu with prices");
		System.out.println("2 : Book Table");
		System.out.println("3 : Order Dish (Enter Quantity)");
		System.out.println("4 : Cancel Order");
		System.out.println("5 : Print Bill/View Order");
		System.out.println("6 : Rate Us/View Rating");

		System.out.println("----------------------------------------");
		TimerEffect.loadEffect("LOADING TO");
		System.out.println();
		System.out.println("Enter your choice");
		return MenuOrder.values()[sc.nextInt()];

	}

	public static void SwitchMenu() {
		MenuOrder choice;
		while (true) {
			try {
				choice = menuList();
				if (choice == MenuOrder.EXIT) {
					break;
				}
				switch (choice) {
				case VIEW:// Dish[] d=Management.getDish();
					// Tester.addDishes(d);
					Tester.printDishes();
					break;
				case BOOK_TABLE:
					Tester.BookTable();
					break;
				case ORDER_MENU:
					Tester.OrderDish(dishcreateRecord());
					break;
				case CANCEL_ORDER:
					Tester.viewOrder();
					System.out.println("Enter INDEX from which u want to REMOVE the dish : ");
					Tester.cancelOrder();
					break;
				case PRINT_BILL:
					// System.out.println("Entr INDEX from which u want to MODIFY the dish PRICE :
					// ");
					// Tester.modifyMenu(sc.nextInt());
					Tester.viewOrder();
					System.out.println();
					Tester.PrintBill();
					break;
				case RATING:
					Tester.Rating();
					break;
				default:
					System.err.println("Invalid choice");

				}
			} catch (InputMismatchException e) {
				System.err.println("INVALID INPUT");
			}
			System.out.println("####################################");
			System.out.println("THANK YOU .....!!!");
			System.out.println("####################################");
			System.out.println();
			System.out.println();

		}

	}

	public static Object dishcreateRecord() {
		System.out.println("Enter index of Dish ");
		int i = sc.nextInt();
		if (i > 0 && i < 10) {
			return i;
		}

		return null;
	}

}
