package ar.edu.unq.po2.tpComposite.uml;

import java.util.List;

public class CarroDeCompras {
	
	private List<Product> products;
	
	public CarroDeCompras(List<Product> products) {
		this.setElements(products);
	}

	private void setElements(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getElements() {
		return this.products;
	}
	
	public int totalRounded() {
		return products.size();
	}
	
	public float total() {
		float price = 0;
		
		for (Product element : products) {
			price += element.getPrice();
		}
		
		return price;
	}

}
