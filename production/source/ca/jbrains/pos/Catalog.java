package ca.jbrains.pos;

import java.util.Map;

public class Catalog {
	private Map<String, Number> pricesByBarcode;

	public Catalog(Map<String, Number> pricesByBarcode) {
		this.pricesByBarcode = pricesByBarcode;
	}

	public boolean hasBarcode(String barcode) {
		return pricesByBarcode.containsKey(barcode);
	}

	public double findPrice(String barcode) {
		return pricesByBarcode.get(barcode).doubleValue();
	}

	public static Catalog withUnformattedPrices(
			Map<String, Number> unformattedPricesByBarcode) {
		return new Catalog(unformattedPricesByBarcode);
	}

}