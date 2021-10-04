package no.hvl.dat152.webStore;

/**
 * A class that defines a product.
 *
 * @author Silja Stubhaug Torkildsen
 */

public class Product {
	
	private int pno;
	private String pName;
	private int priceInEuro;
	private String imageFile;
	
	//constructor
	public Product(int pno, String pName, int priceInEuro, String imageFile) {
		this.pno = pno;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.imageFile = imageFile;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPriceInEuro() {
		return priceInEuro;
	}

	public void setPriceInEuro(int priceInEuro) {
		this.priceInEuro = priceInEuro;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	
}
