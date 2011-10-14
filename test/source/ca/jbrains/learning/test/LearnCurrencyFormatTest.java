package ca.jbrains.learning.test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

import org.junit.Test;

public class LearnCurrencyFormatTest {
	@Test
	public void whatDoesItDoByDefault() throws Exception {
		assertEquals("11,45 Û",
				NumberFormat.getCurrencyInstance(new Locale("fr", "FR"))
						.format(11.45d));
	}

	@Test
	public void useFormatter() throws Exception {
		Formatter formatter = new Formatter(new Locale("fr", "FR"));
		formatter.format("EUR %.2f", 11.45d);
		String formatted = formatter.toString();
		assertEquals("EUR 11,45", formatted);
	}

	@Test
	public void doItMoreDirectly() throws Exception {
		assertEquals("EUR 11,45",
				formatAmountAsEuroThePreferredWay(11.45d));
	}

	private String formatAmountAsEuroThePreferredWay(double amount) {
		return String.format(Locale.FRANCE, "EUR %.2f", amount);
	}
}
