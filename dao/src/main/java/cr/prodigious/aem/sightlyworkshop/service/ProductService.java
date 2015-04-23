package cr.prodigious.aem.sightlyworkshop.service;

import java.util.List;

import cr.prodigious.aem.sightlyworkshop.model.Product;

public interface ProductService {
	
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
	void removeProduct(int productID);
	
	Product getProductByID(int productID);
	
	List<Product> listProducts();
	
	List<Product> listProductsByCategoryCode(String categoryCode);

}
