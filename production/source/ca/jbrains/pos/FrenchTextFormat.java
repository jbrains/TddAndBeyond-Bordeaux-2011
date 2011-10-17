package ca.jbrains.pos;

import java.util.Locale;


public class FrenchTextFormat implements TextFormat {
	@Override
	public String format(Price price) {
		return String.format(Locale.FRANCE, "EUR %.2f",
				(double) price.getValueInEuro());
	}

	public String format(ProductNotFoundMessage message) {
		return "Produit inconnu " + message.getBarcode();
	}

	@Override
	public String format(EmptyBarcodeMessage emptyBarcodeMessage) {
		return "Barcode vide";
	}
}