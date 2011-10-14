package ca.jbrains.pos;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

public class Catalog {
	private Map<String, Number> pricesByBarcode;

	public Catalog(Map<String, Number> pricesByBarcode) {
		this.pricesByBarcode = pricesByBarcode;
	}

	public boolean hasBarcode(String barcode) {
		return pricesByBarcode.containsKey(barcode);
	}

	public double findPrice(String barcode) {
		return pricesByBarcode.get(barcode).doubleValue();
	}

	public static Catalog withUnformattedPrices(
			Map<String, Number> unformattedPricesByBarcode) {
		return new Catalog(unformattedPricesByBarcode);
	}

	public static Map<String, Number> transformValues(
			Map<String, String> input, Function<String, Number> function) {

		Map<String, Number> transformed = Maps.newHashMap();
		for (Map.Entry<String, String> eachEntry : input.entrySet()) {
			transformed.put(eachEntry.getKey(),
					function.apply(eachEntry.getValue()));
		}
		return transformed;
	}

}