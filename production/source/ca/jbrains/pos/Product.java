package ca.jbrains.pos;

public class Product {
	public double price;
	public boolean pstApplies;

	public Product(double price, boolean pstApplies) {
		this.price = price;
		this.pstApplies = pstApplies;
	}

	public double cost() {
		return price + (price * 0.05d) + (pstApplies ? (price * 0.08d) : 0.0d);
	}
}