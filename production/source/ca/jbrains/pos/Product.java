package ca.jbrains.pos;

public class Product {
	private double price;

	private boolean pstApplies;

	public Product(double price, boolean pstApplies) {
		this.price = price;
		this.pstApplies = pstApplies;
	}

	public double cost() {
		return getPrice() + Math.round(getPrice() * 5d) / 100.0d
				+ (pstApplies ? Math.round(getPrice() * 8d) / 100.0d : 0.0d);
	}

	public double getPrice() {
		return price;
	}
}