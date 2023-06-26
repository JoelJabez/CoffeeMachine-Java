package machine;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		boolean isDone = false;
		while (!isDone) {
			System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
			String action = scanner.nextLine().toLowerCase();

			isDone = CoffeeMachine.start(action);
		}
	}
}
