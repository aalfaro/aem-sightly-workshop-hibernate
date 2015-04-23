package cr.prodigious.aem.sightlyworkshop.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cr.prodigious.aem.sightlyworkshop.dao.ProductDAO;
import cr.prodigious.aem.sightlyworkshop.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;	
    
	public void addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		LOG.info("Product saved successfully, Product details="+product);
	}
	
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		LOG.info("Product updated successfully, Product details="+product);
	}
	
	public void removeProduct(int productID) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.load(Product.class, new Integer(productID));
		if(null != product){
			session.delete(product);
		}
		LOG.info("Product deleted successfully, Product details="+product);
	}
	
	public Product getProductByID(int productID) {
		Session session = this.sessionFactory.getCurrentSession();		
		Product product = (Product) session.load(Product.class, new Integer(productID));
		LOG.info("Product loaded successfully, Product details="+product);
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> listProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Product> products = session.createQuery("from Product p order by p.category.categoryCode").list();
		return products;
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listProductsByCategoryCode(String categoryCode) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Product p where p.category.categoryCode = :categoryCode");
		query.setParameter("categoryCode", categoryCode);
		List<Product> products = query.list();
		return products;
	}

}