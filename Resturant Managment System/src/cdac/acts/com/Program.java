package cdac.acts.com;

import cdac.acts.com.*;
import cdac.acts.com.Management.Menu;

import java.util.*;
import cdac.acts.thread.*;

public class Program {
	private static Scanner sc = new Scanner(System.in);

	public static Dish dishcreateRecord() {
		Dish dish = new Dish();
		sc.nextLine();
		System.out.println("Enter name of the DISH : ");
		dish.setDishName(sc.nextLine());
		System.out.println("Enter price of the DISH : ");
		dish.setPrice(sc.nextFloat());

		return dish;

	}

	enum Menu {
		EXIT, MANAGEMENT, CUSTOMER
	}

	public static Menu menuList() throws ArrayIndexOutOfBoundsException {
		
		System.out.println("******Choose Option**********");
		System.out.println("0. Exit the program");
		System.out.println("Choose 1 If you are from Managment Team");
		System.out.println("Choose 2 If you are a Customer ");
		System.out.println();
		System.out.println("----------------------------------------");
		TimerEffect.loadEffect("      Select Option    ");
		System.out.println("      1. Management Team ");
		System.out.println("      2. Customer ");
		System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("Plzz Enter your choice");
		return Menu.values()[sc.nextInt()];

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
				case MANAGEMENT:
					Management.SwitchMenu();
					break;
				case CUSTOMER:
					User.SwitchMenu();
					break;
				default:
					System.err.println("Invalid choice");

				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("INVALID INPUT");

			} catch (ArrayIndexOutOfBoundsException e) {
				sc.nextLine();
				System.err.println("INVALID INPUT");

				System.out.println();
				System.out.println("THANK YOU .....!!!");
				System.out.println();
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
			}
			System.out.println("We Would Like TO SEE U Again");
		}

	}

	public static void main(String[] args) {
		Tester t = new Tester();
		t.setDishList(new ArrayList<>());
		t.setCoustomerList(new ArrayList<>());
		System.out.println("!!!!.... WELCOME WELCOME WELCOME ....!!!!");
		
		TimerEffect.loadEffect("  ");
		System.out.println();
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println("****   WELCOME TO CHOPS AND HOPS   ****");
		System.out.println("***************************************");
		System.out.println("***************************************");
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println("RESTURANT Started By SAKSHI & FAHAD");
		System.out.println("----------------------------------------");
		 TimerEffect.loadEffect("");
		Dish[] d = Management.getDish();
		Tester.addDishes(d);
		Program.SwitchMenu();
	}

}
