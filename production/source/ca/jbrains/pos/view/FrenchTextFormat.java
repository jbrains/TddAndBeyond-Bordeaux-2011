package ca.jbrains.pos.view;

import java.util.Locale;

import ca.jbrains.pos.model.NoSaleInProgressMessage;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.util.NotYetImplementedException;


public final class FrenchTextFormat implements TextFormat {
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

	@Override
	public String format(NoSaleInProgressMessage noSaleInProgressMessage) {
		throw new NotYetImplementedException();
	}
}