package no.hvl.dat152.webStore;

/**
 * A class that defines the web store. 
 * Contaning the products and cart, internationalized localized to three locations.
 *
 * @author Silja Stubhaug Torkildsen
 */



import java.util.ArrayList;
import java.util.Optional;

public class Store {
	
	//Product list
	private ArrayList<Product> products = new ArrayList<Product>();
	
	//Product description list
	private ArrayList<Description> descriptions = new ArrayList<Description>();
	
	
	// Store
	public Store() {
		products.add(new Product(0,"Kanye Coffee Cup", 25, "whitemug.jpg"));
		products.add(new Product(1,"Prescription Coffee Cup", 13, "kaffemugg.jpg"));
		
		this.descriptions.add(new Description(0, "en_US", "It's a Kanye cup!"));
		this.descriptions.add(new Description(1, "en_US", "The perfect gift for a coffe addict!"));
		this.descriptions.add(new Description(0, "nb_NO", "Det er en Kanye kopp!"));
		this.descriptions.add(new Description(1, "nb_NO", "Den perfekte gaven til kaffemisbrukere!"));
		this.descriptions.add(new Description(0, "nn_NO", "Det er ein Kanye kopp!"));
		this.descriptions.add(new Description(1, "nn_NO", "Den perfekte gåva til kaffemisbrukere!"));
		this.descriptions.add(new Description(0, "fr_FR", "C'est une tasse Kanye !"));
		this.descriptions.add(new Description(1, "fr_FR", "Le cadeau parfait pour les accros du café !"));
		
	}
	
	
	public Description getDescription(int pno, String locale) {
		Optional<Description> desReturn = this.descriptions.stream().filter(d -> d.getPno() == pno && d.getLangCode().equals(locale)).findFirst();
		if(desReturn.isPresent()) {
			return desReturn.get();
		} else return null;
	}
	
	public Product getProduct(int pno) {
		Optional<Product> prdReturn = this.products.stream().filter(p -> p.getPno() == pno).findFirst();
		if(prdReturn.isPresent()) {
			return prdReturn.get();
		} else return null;
	}
	
	public ArrayList<Product> getProducts(){
		return this.products;
	}

}
