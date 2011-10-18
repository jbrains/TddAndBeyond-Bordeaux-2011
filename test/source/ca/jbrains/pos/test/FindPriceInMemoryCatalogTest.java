package ca.jbrains.pos.test;

import java.util.Collections;

import ca.jbrains.pos.model.Catalog;
import ca.jbrains.pos.model.InMemoryCatalog;
import ca.jbrains.pos.model.Price;


public class FindPriceInMemoryCatalogTest extends CatalogContract {
	@Override
	public Catalog catalogWithout(String barcode) {
		return new InMemoryCatalog(Collections.<String, Price> singletonMap(
				"not " + barcode, Price.euro(1000000)));
	}

	@Override
	public Catalog catalogWith(String barcode, Price price) {
		return new InMemoryCatalog(Collections.<String, Price> singletonMap(
				barcode, price));
	}
}
