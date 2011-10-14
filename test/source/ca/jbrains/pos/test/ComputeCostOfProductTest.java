package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.jbrains.pos.Product;

public class ComputeCostOfProductTest {
	@Test
	public void gstAndPst() throws Exception {
		assertEquals(11.3d, new Product(10.0d, true).cost(), 0.001d);
	}

	@Test
	public void gstOnly() throws Exception {
		assertEquals(10.5d, new Product(10.0d, false).cost(), 0.001d);
	}
}
