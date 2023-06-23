package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

		// Declaring and initializing constant per cup
		final int amountOfWaterPerCup = 200;
		final int amountOfMilkPerCup = 50;
		final int amountOfCoffeeBeansPerCup = 15;

		// Getting input from the user
	    System.out.println("Write how many ml of water the coffee beans has: ");
	    final int amountOfWater = scanner.nextInt();

	    System.out.println("Write how many ml of milk the coffee beans has: ");
	    final int amountOfMilk = scanner.nextInt();

	    System.out.println("Write how many grams of coffee beans the coffee beans has: ");
	    final int amountOfCoffeeBeans = scanner.nextInt();

	    System.out.println("Write how many cups of coffee you will need: ");
		final int amountOfCups = scanner.nextInt();

		// Dividing the amount from the user with the constant
		int minimumAmountOfWater = amountOfWater / amountOfWaterPerCup;
	    int minimumAmountOfMilk = amountOfMilk / amountOfMilkPerCup;
	    int minimumAmountOfCoffeeBeans = amountOfCoffeeBeans / amountOfCoffeeBeansPerCup;

		// Getting the minimum number
		int minimumCups = Math.min(minimumAmountOfWater, Math.min(minimumAmountOfMilk, minimumAmountOfCoffeeBeans));

		// Printing the message
		switch (Integer.compare(minimumCups, amountOfCups)) {
			case 1 -> System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", minimumCups - amountOfCups);
			case 0 -> System.out.println("Yes, I can make that amount of coffee");
			case -1 -> System.out.printf("No, I can make only %d cup(s) of coffee", minimumCups);
		}
    }
}
