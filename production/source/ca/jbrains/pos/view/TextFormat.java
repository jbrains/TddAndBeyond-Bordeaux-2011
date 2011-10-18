package ca.jbrains.pos.view;

import ca.jbrains.pos.model.NoSaleInProgressMessage;
import ca.jbrains.pos.model.Price;


public interface TextFormat {
	String format(Price price);

	String format(ProductNotFoundMessage productNotFoundMessage);

	String format(EmptyBarcodeMessage emptyBarcodeMessage);

	String format(NoSaleInProgressMessage noSaleInProgressMessage);
}