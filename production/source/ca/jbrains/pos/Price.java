package ca.jbrains.pos;

import java.util.Locale;

public class Price {
	private final int valueInEuro;

	public Price(int valueInEuro) {
		this.valueInEuro = valueInEuro;
	}

	public static Price euro(int valueInEuro) {
		return new Price(valueInEuro);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Price) {
			Price that = (Price) other;
			return this.valueInEuro == that.valueInEuro;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return valueInEuro;
	}

	@Override
	public String toString() {
		return String.valueOf(valueInEuro) + "Û";
	}

	public String format() {
		return String.format(Locale.FRANCE, "EUR %.2f", (double) valueInEuro);
	}
}