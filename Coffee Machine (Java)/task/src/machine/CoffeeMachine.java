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

		printStatusOfCoffeeMachine();
	    System.out.println("Write action (buy, fill, take): ");
		String action = scanner.nextLine();

		switch (action) {
			case "buy" -> {
				System.out.print("What do you want to buy? ");
				for (Coffee coffee: Coffee.values()) {
					if (coffee.getNumber() != 1) {
						System.out.print(", ");
					}
					System.out.print(coffee.getNumber() + " - " + coffee.getCoffeeName());
				}
				System.out.println(":");

				int number = scanner.nextInt();
				switch (number) {
					case 1 -> {
						Coffee espresso = Coffee.ESPRESSO;

						amountOfWater -= espresso.getAmountOfWaterRequired();
						amountOfMilk -= espresso.getAmountOfMilkRequired();
						amountOfCoffee -= espresso.getAmountOfCoffeeBeansRequired();
						cash += espresso.getCost();
					}

					case 2 -> {
						Coffee latte = Coffee.LATTE;

						amountOfWater -= latte.getAmountOfWaterRequired();
						amountOfMilk -= latte.getAmountOfMilkRequired();
						amountOfCoffee -= latte.getAmountOfCoffeeBeansRequired();
						cash += latte.getCost();
					}

					case 3 -> {
						Coffee cappuccino = Coffee.CAPPUCCINO;

						amountOfWater -= cappuccino.getAmountOfWaterRequired();
						amountOfMilk -= cappuccino.getAmountOfMilkRequired();
						amountOfCoffee -= cappuccino.getAmountOfCoffeeBeansRequired();
						cash += cappuccino.getCost();
					}

					default -> {
						System.out.println("Invalid input");
						return;
					}
				}
				amountOfCups -= 1;
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
			}

			case "take" -> {
				System.out.printf("I gave you $%d\n", cash);
				System.out.println();
				cash = 0;
			}

			default -> {
				System.out.println("Invalid input");
				return;
			}
		}
		printStatusOfCoffeeMachine();
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
}
