package ca.jbrains.learning.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ca.jbrains.pos.ParseFrenchNumbersAsDouble;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

public class LearnTransformingMapValuesTest {
	@Test
	public void translateStringsIntoNumbers() throws Exception {
		@SuppressWarnings("serial")
		Map<String, Number> expected = new HashMap<String, Number>() {
			{
				put("12345", 10.0d);
				put("23456", 23.45d);
				put("34567", 9.99d);
			}
		};

		@SuppressWarnings("serial")
		Map<String, String> input = new HashMap<String, String>() {
			{
				put("12345", "10,00");
				put("23456", "23,45");
				put("34567", "9,99");
			}
		};

		assertEquals(expected,
				transformValues(input, new ParseFrenchNumbersAsDouble()));
	}

	public static Map<String, Number> transformValues(
			Map<String, String> input, Function<String, Number> function) {

		// I ended up using this in production
		Map<String, Number> transformed = Maps.newHashMap();
		for (Map.Entry<String, String> eachEntry : input.entrySet()) {
			transformed.put(eachEntry.getKey(),
					function.apply(eachEntry.getValue()));
		}
		return transformed;
	}
}
