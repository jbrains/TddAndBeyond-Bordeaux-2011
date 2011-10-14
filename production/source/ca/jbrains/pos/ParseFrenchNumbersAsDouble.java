package ca.jbrains.pos;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.google.common.base.Function;

public final class ParseFrenchNumbersAsDouble implements
		Function<String, Number> {
	@Override
	public Number apply(String each) {
		try {
			return NumberFormat.getNumberInstance(Locale.FRANCE).parse(each)
					.doubleValue();
		} catch (ParseException wrapped) {
			throw new RuntimeException("Unable to parse number", wrapped);
		}
	}
}