package ca.jbrains.pos;

import java.util.Map;

public class Catalog {
	public static Catalog withFormattedPrices(
			Map<String, String> pricesByBarcode) {
		return new Catalog(pricesByBarcode);
	}

	public Map<String, String> pricesByBarcode;

	private Catalog(Map<String, String> pricesByBarcode) {
		this.pricesByBarcode = pricesByBarcode;
	}

	public boolean hasBarcode(String barcode) {
		return pricesByBarcode.containsKey(barcode);
	}

	public String findPrice(String barcode) {
		return pricesByBarcode.get(barcode);
	}

	public static Catalog withUnformattedPrices(
			Map<String, Number> unformattedPricesByBarcode) {
		throw new UnsupportedOperationException(
				"First, remember how to translate map values");
	}
}