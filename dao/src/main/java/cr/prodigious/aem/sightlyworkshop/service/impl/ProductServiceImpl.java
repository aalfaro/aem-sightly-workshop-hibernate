package cr.prodigious.aem.sightlyworkshop.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cr.prodigious.aem.sightlyworkshop.dao.ProductDAO;
import cr.prodigious.aem.sightlyworkshop.model.Product;
import cr.prodigious.aem.sightlyworkshop.service.ProductService;

@Transactional
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDAO productDAO;
	
	public void addProduct(Product product) {
		this.productDAO.addProduct(product);
	}

	public void updateProduct(Product product) {
		this.productDAO.updateProduct(product);
	}
	
	public void removeProduct(int productID) {
		this.productDAO.removeProduct(productID);
	}
	
	public Product getProductByID(int productID) {
		return this.productDAO.getProductByID(productID);
	}

	public List<Product> listProducts() {		
		
		List<Product> products = null;
		// We can add cache logic here 
		try {
			products = productDAO.listProducts();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return products;
		
	}
	
	public List<Product> listProductsByCategoryCode(String categoryCode) {
		
		List<Product> products = null;
		// We can add cache logic here 
		try {
			products = productDAO.listProductsByCategoryCode(categoryCode);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return products;
	}
	
}
