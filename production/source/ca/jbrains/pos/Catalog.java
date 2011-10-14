package ca.jbrains.pos;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

public class Catalog {
	public static Catalog withFormattedPrices(
			Map<String, String> pricesAsTextByBarcode) {
		return new Catalog(pricesAsTextByBarcode);
	}

	private Map<String, Number> pricesByBarcode;
	private Map<String, String> pricesAsTextByBarcode;
	
	public Catalog(Map<String, String> pricesAsTextByBarcode,
			Map<String, Number> pricesByBarcode) {

		this.pricesAsTextByBarcode = pricesAsTextByBarcode;
		this.pricesByBarcode = pricesByBarcode;
	}

	private Catalog(Map<String, String> pricesByBarcode) {
		this.pricesAsTextByBarcode = pricesByBarcode;
		this.pricesByBarcode = transformValues(pricesByBarcode,
				new Function<String, Number>() {
					@Override
					public Number apply(String each) {
						return new ParseFrenchNumbersAsDouble().apply(each
								.substring(4));
					}
				});
	}

	public boolean hasBarcode(String barcode) {
		return pricesByBarcode.containsKey(barcode);
	}

	public String findPrice(String barcode) {
		return Sale.formatAmount(pricesByBarcode.get(barcode).doubleValue());
	}

	public static Catalog withUnformattedPrices(
			Map<String, Number> unformattedPricesByBarcode) {

		return new Catalog(null, unformattedPricesByBarcode);
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