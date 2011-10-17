package ca.jbrains.pos;

import java.io.PrintWriter;
import java.util.HashMap;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintWriter canvas = new PrintWriter(System.out, true);
		SaleController saleController = new SaleController(new InMemoryCatalog(
				new HashMap<String, Price>() {
					{
						put("12345", Price.euro(12));
						put("23456", Price.euro(70));
						put("34567", Price.euro(89));
					}
				}), new TextDisplay(canvas));

		saleController.onBarcode("12345");
		saleController.onBarcode("23456");
		saleController.onBarcode("34567");
		saleController.onBarcode("");
		saleController.onBarcode("99999");
		saleController.onBarcode(null);
		canvas.flush();
		canvas.close();
	}
}
