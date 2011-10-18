package ca.jbrains.pos.view.test;

import org.junit.Test;

public abstract class DisplayContract {

	@Test
	public abstract void displayNonNullPrice() throws Exception;

	@Test
	public abstract void displayProductNotFoundMessageWithNonNullBarcode()
			throws Exception;

	@Test
	public abstract void displayEmptyBarcodeMessage() throws Exception;
}
