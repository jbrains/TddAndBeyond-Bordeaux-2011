package ca.jbrains.pos.view.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.view.FrenchTextFormat;

public class FrenchTextFormatTest {
	@Test
	public void price() throws Exception {
		assertEquals("EUR 90,00", new FrenchTextFormat().format(Price.euro(90)));
	}
}
