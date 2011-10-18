package ca.jbrains.pos;

import java.io.PrintWriter;
import java.util.HashMap;

import ca.jbrains.pos.controller.SaleController;
import ca.jbrains.pos.model.Catalog;
import ca.jbrains.pos.model.InMemoryCatalog;
import ca.jbrains.pos.model.Price;
import ca.jbrains.pos.view.CashRegisterView;
import ca.jbrains.pos.view.FrenchTextFormat;
import ca.jbrains.pos.view.PrintWriterCanvas;

public class Driver {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		PrintWriter output = new PrintWriter(System.out, true);

		Catalog model = new InMemoryCatalog(
				new HashMap<String, Price>() {
					{
						put("12345", Price.euro(12));
						put("23456", Price.euro(70));
						put("34567", Price.euro(89));
					}
				});

		CashRegisterView view = new CashRegisterView(new FrenchTextFormat(),
				new PrintWriterCanvas(output));
		
		SaleController saleController = new SaleController(model, view);
		saleController.onBarcode("12345");
		saleController.onBarcode("23456");
		saleController.onBarcode("34567");
		saleController.onBarcode("");
		saleController.onBarcode("99999");
		saleController.onBarcode(null);
		
		output.flush();
		output.close();
	}
}
