package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import ca.jbrains.pos.model.Catalog;
import ca.jbrains.pos.model.Price;


public abstract class CatalogContract {
	@Test
	public void productFound() throws Exception {
		Catalog catalog = catalogWith("12345", Price.euro(12));
		assertEquals(Price.euro(12), catalog.findPrice("12345"));
	}

	@Test
	public void productNotFound() throws Exception {
		Catalog catalog = catalogWithout("12345");
		assertNull(catalog.findPrice("12345"));

	}

	public abstract Catalog catalogWithout(String barcode);

	public abstract Catalog catalogWith(String barcode, Price price);
}
