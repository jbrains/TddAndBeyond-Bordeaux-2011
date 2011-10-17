package ca.jbrains.pos;

public class ProductNotFoundMessage {
	private String barcode;

	public String getBarcode() {
		return barcode;
	}

	public ProductNotFoundMessage(String barcode) {
		this.barcode = barcode;
	}

}