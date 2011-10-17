package ca.jbrains.pos.test;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.junit.Test;

import ca.jbrains.pos.Display;
import ca.jbrains.pos.Price;
import ca.jbrains.pos.TextDisplay;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class TextDisplayTest extends DisplayContract {
	public static class MoreLists {
		public static <T> List<T> chomp(List<T> list) {
			return list.subList(0, list.size() - 1);
		}
	}

	public static class Lines {
		public static List<String> parseChompingFinalBlankLine(
				String multilineString) {

			return MoreLists.chomp(Lists.newArrayList(Splitter.on("\n").split(
					multilineString)));
		}
	}

	@Test
	public void displayNonNullPrice() throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayPrice(Price.euro(12));
		assertEquals(Lists.newArrayList("EUR 12,00"),
				Lines.parseChompingFinalBlankLine(canvas.toString()));
	}

	private TextDisplay createDisplayWritingTo(StringWriter canvas) {
		return new TextDisplay(new PrintWriter(canvas, true));
	}

	@Override
	public void displayProductNotFoundMessageWithNonNullBarcode()
			throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayProductNotFoundMessage("99999");
		assertEquals(Lists.newArrayList("No product found for 99999"),
				Lines.parseChompingFinalBlankLine(canvas.toString()));
	}

	@Override
	public void displayEmptyBarcodeMessage() throws Exception {
		StringWriter canvas = new StringWriter();
		Display display = createDisplayWritingTo(canvas);
		display.displayEmptyBarcodeMessage();
		assertEquals(Lists.newArrayList("Scanning error: empty barcode"),
				Lines.parseChompingFinalBlankLine(canvas.toString()));
	}
}
