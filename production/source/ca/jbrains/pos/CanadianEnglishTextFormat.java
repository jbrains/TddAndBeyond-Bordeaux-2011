package ca.jbrains.pos;

import java.util.Locale;

public final class CanadianEnglishTextFormat implements TextFormat {
	@Override
	public String format(Price price) {
		return String.format(Locale.CANADA, "$%.2f",
				(double) price.getValueInEuro());
	}

	@Override
	public String format(ProductNotFoundMessage productNotFoundMessage) {
		return "Product " + productNotFoundMessage.getBarcode()
				+ " not found, eh?";
	}

	@Override
	public String format(EmptyBarcodeMessage emptyBarcodeMessage) {
		return "Whoa: no barcode. Sucks.";
	}
}