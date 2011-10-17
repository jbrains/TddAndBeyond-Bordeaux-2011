package ca.jbrains.pos;

import java.util.Map;

public class Catalog {
	private final Map<String, Product> productsByBarcode;

	public Catalog(Map<String, Product> productsByBarcode) {
		this.productsByBarcode = productsByBarcode;
	}

	public boolean hasBarcode(String barcode) {
		return productsByBarcode.containsKey(barcode);
	}

	public Product findProduct(String barcode) {
		return productsByBarcode.get(barcode);
	}

	public static Catalog withProducts(Map<String, Product> productsByBarcode) {
		return new Catalog(productsByBarcode);
	}
}