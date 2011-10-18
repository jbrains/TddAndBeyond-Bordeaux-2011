package ca.jbrains.pos.model;

import java.util.Map;


public class InMemoryCatalog implements Catalog {
	private final Map<String, Price> pricesByBarcode;

	public InMemoryCatalog(Map<String, Price> pricesByBarcode) {
		this.pricesByBarcode = pricesByBarcode;
	}

	@Override
	public Price findPrice(String barcode) {
		return pricesByBarcode.get(barcode);
	}
}