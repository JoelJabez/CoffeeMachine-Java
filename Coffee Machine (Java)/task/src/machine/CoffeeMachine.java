package machine;

import java.util.Scanner;

public class CoffeeMachine {
	private static int amountOfWater = 400;
	private static int amountOfMilk = 540;
	private static int amountOfCoffee = 120;
	private static int amountOfCups = 9;
	private static int cash = 550;

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    boolean isDone = false;
	    while (!isDone) {
		    System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
		    String action = scanner.nextLine().toLowerCase();

		    switch (action) {
			    case "buy" -> {
				    System.out.print("What do you want to buy? ");
				    for (Coffee coffee : Coffee.values()) {
					    if (coffee.ordinal() != 0) {
						    System.out.print(", ");
					    }
					    System.out.print(coffee.ordinal() + 1 + " - " + coffee.getCoffeeName());
				    }
				    System.out.println(", back - to main menu:");

				    String coffeeIndex = scanner.nextLine();
				    switch (coffeeIndex) {
					    case "1" -> tryToBuyCoffee(Coffee.ESPRESSO);
					    case "2" -> tryToBuyCoffee(Coffee.LATTE);
					    case "3" -> tryToBuyCoffee(Coffee.CAPPUCCINO);

					    case "back" -> {}

					    default -> {
						    System.out.println("Invalid input");
						    return;
					    }
				    }
			    }

			    case "fill" -> {
				    System.out.println("Write how many ml of water you want to add:");
				    int addWater = scanner.nextInt();

				    System.out.println("Write how many ml of milk you want to add:");
				    int addMilk = scanner.nextInt();

				    System.out.println("Write how many grams of coffee beans you want to add:");
				    int addCoffeeBeans = scanner.nextInt();

				    System.out.println("Write how many disposable cups you want to add:");
				    int addCups = scanner.nextInt();

				    amountOfWater += addWater;
				    amountOfMilk += addMilk;
				    amountOfCoffee += addCoffeeBeans;
				    amountOfCups += addCups;

					scanner.nextLine();
			    }

			    case "take" -> {
				    System.out.printf("I gave you $%d\n", cash);
				    System.out.println();
				    cash = 0;
			    }

				case "remaining" -> printStatusOfCoffeeMachine();
			    case "exit" -> isDone = true;
			    default -> System.out.println("Invalid input");
		    }
	    }
    }

	private static void printStatusOfCoffeeMachine() {
		System.out.println("The coffee machine has:");
		System.out.printf("%d ml of water\n", amountOfWater);
		System.out.printf("%d ml of milk\n", amountOfMilk);
		System.out.printf("%d g of coffee beans\n", amountOfCoffee);
		System.out.printf("%d disposable cups\n", amountOfCups);
		System.out.printf("$%d of money\n", cash);
		System.out.println();
	}

	private static void tryToBuyCoffee(Coffee coffee) {
		// Checking whether the machine has enough water
		if (coffee.getAmountOfWaterRequired() > amountOfWater) {
			System.out.println("Sorry, not enough water!");
		}
		// Checking whether the machine has enough milk
		else if (coffee.getAmountOfMilkRequired() > amountOfMilk) {
			System.out.println("Sorry not enough milk!");
		}
		// Checking whether the machine has enough coffee beans
		else if (coffee.getAmountOfCoffeeBeansRequired() > amountOfCoffee) {
			System.out.println("Sorry not enough coffee beans!");
		}
		// Checking whether the machine has enough cups
		else if (amountOfCups == 0) {
			System.out.println("Sorry not enough cups");
		}
		// Else the user can buy the coffee
		else {
			System.out.println("I have enough resources, making you a coffee!\n");
			amountOfWater -= coffee.getAmountOfWaterRequired();
			amountOfMilk -= coffee.getAmountOfMilkRequired();
			amountOfCoffee -= coffee.getAmountOfCoffeeBeansRequired();
			cash += coffee.getCost();
			amountOfCups -= 1;
		}
	}
}
