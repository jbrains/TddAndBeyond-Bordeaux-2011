package ca.jbrains.learning.test;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;

public class LearnParseNumbersTest {
	@Test
	public void parsesAsIntegerEvenWhenIWantDouble() throws Exception {
		assertEquals(Long.valueOf(10),
				NumberFormat.getNumberInstance(Locale.FRANCE).parse("10,00"));
	}

	@Test
	public void coerceParsedNumberAsDouble() throws Exception {
		assertEquals(10.0d, NumberFormat.getNumberInstance(Locale.FRANCE)
				.parse("10,00").doubleValue(), 0.0d);
	}
}
