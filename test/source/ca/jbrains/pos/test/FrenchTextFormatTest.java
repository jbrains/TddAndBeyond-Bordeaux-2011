package ca.jbrains.pos.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.jbrains.pos.FrenchTextFormat;
import ca.jbrains.pos.Price;

public class FrenchTextFormatTest {
	@Test
	public void price() throws Exception {
		assertEquals("EUR 90,00", new FrenchTextFormat().format(Price.euro(90)));
	}
}
