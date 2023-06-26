package machine;

public enum Coffee {
	ESPRESSO("espresso", 250, 0, 16, 4),
	LATTE("latte", 350, 75, 20, 7),
	CAPPUCCINO("cappuccino", 200, 100, 12, 6);

	private final String coffeeName;
	private final int amountOfWaterRequired;
	private final int amountOfMilkRequired;
	private final int amountOfCoffeeBeansRequired;
	private final int cost;

	Coffee(String coffeeName,  int amountOfWaterRequired, int amountOfMilkRequired,
	       int amountOfCoffeeBeansRequired, int cost) {

		this.coffeeName = coffeeName;
		this.amountOfWaterRequired = amountOfWaterRequired;
		this.amountOfMilkRequired = amountOfMilkRequired;
		this.amountOfCoffeeBeansRequired = amountOfCoffeeBeansRequired;
		this.cost = cost;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public int getAmountOfWaterRequired() {
		return amountOfWaterRequired;
	}

	public int getAmountOfMilkRequired() {
		return amountOfMilkRequired;
	}

	public int getAmountOfCoffeeBeansRequired() {
		return amountOfCoffeeBeansRequired;
	}

	public int getCost() {
		return cost;
	}
}
