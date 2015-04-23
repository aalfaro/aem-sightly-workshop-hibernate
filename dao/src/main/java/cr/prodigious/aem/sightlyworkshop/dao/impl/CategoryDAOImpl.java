package cr.prodigious.aem.sightlyworkshop.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cr.prodigious.aem.sightlyworkshop.dao.CategoryDAO;
import cr.prodigious.aem.sightlyworkshop.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	private static final Logger LOG = LoggerFactory.getLogger(CategoryDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;	
    
	public void addCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(category);
		LOG.info("Category saved successfully, Category details="+category);
	}
	
	public void updateCategory(Category category) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(category);
		LOG.info("Category updated successfully, Category details="+category);
	}
	
	public void removeCategory(int categoryID) {
		Session session = this.sessionFactory.getCurrentSession();
		Category category = (Category) session.load(Category.class, new Integer(categoryID));
		if(null != category){
			session.delete(category);
		}
		LOG.info("Category deleted successfully, Category details="+category);
	}
	
	public Category getCategoryByID(int categoryID) {
		Session session = this.sessionFactory.getCurrentSession();		
		Category category = (Category) session.load(Category.class, new Integer(categoryID));
		LOG.info("Category loaded successfully, Category details="+category);
		return category;
	}

	@SuppressWarnings("unchecked")
	public List<Category> listCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("from Category").list();
		return categories;
	}

	public Category getCategoryByCode(String categoryCode) {
		Category category = null;
		
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Category.class).add(Restrictions.eq("categoryCode", categoryCode));
		
		Object result = criteria.uniqueResult();
        if (null != result) {
        	 category = (Category) result;
        	 LOG.info("Category loaded successfully, Category details="+category);
        }
		
		return category;
	}

}