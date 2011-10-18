package ca.jbrains.pos.view;

import java.util.Locale;

import ca.jbrains.pos.model.NoSaleInProgressMessage;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.util.NotYetImplementedException;

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

	@Override
	public String format(NoSaleInProgressMessage noSaleInProgressMessage) {
		throw new NotYetImplementedException();
	}
}