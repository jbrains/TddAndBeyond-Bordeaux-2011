package ca.jbrains.pos.model;

public interface Catalog {
	Price findPrice(String barcode);
}