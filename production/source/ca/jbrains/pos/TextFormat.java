package ca.jbrains.pos;


public interface TextFormat {
	String format(Price price);

	String format(ProductNotFoundMessage productNotFoundMessage);

	String format(EmptyBarcodeMessage emptyBarcodeMessage);
}