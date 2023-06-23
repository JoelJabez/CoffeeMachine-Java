package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Write how many cups of coffee you will need: ");
		final int cups = scanner.nextInt();

		final int amountOfWater = cups * 200;
		final int amountOfMilk = cups * 50;
		final int amountOfCoffeeBeans = cups * 15;

	    System.out.printf("For %d cups of coffee you will need: \n", cups);

	    System.out.printf("%d ml of water\n", amountOfWater);
	    System.out.printf("%d ml of milk\n", amountOfMilk);
	    System.out.printf("%d g of coffee beans\n", amountOfCoffeeBeans);
    }
}
