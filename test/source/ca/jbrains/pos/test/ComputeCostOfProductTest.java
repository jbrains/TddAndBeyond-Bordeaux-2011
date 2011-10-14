package ca.jbrains.pos.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.jbrains.pos.Product;
import ca.jbrains.pos.Sale;

public class ComputeCostOfProductTest {
	private Sale sale;

	@Before
	public void setUp() {
		// SMELL
		sale = new Sale(null, null);
	}

	@Test
	public void gstAndPst() throws Exception {
		assertEquals(11.3d, new Product(10.0d, true).cost(), 0.001d);
	}

	@Test
	public void gstOnly() throws Exception {
		assertEquals(10.5d, new Product(10.0d, false).cost(), 0.001d);
	}
}
