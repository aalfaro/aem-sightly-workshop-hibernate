package cr.prodigious.aem.sightlyworkshop.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cr.prodigious.aem.sightlyworkshop.dao.CategoryDAO;
import cr.prodigious.aem.sightlyworkshop.model.Category;
import cr.prodigious.aem.sightlyworkshop.service.CategoryService;

@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	public void addCategory(Category category) {
		this.categoryDAO.addCategory(category);
	}

	public void updateCategory(Category category) {
		this.categoryDAO.updateCategory(category);
	}
	
	public void removeCategory(int categoryID) {
		this.categoryDAO.removeCategory(categoryID);
	}
	
	public Category getCategoryByID(int categoryID) {
		return this.categoryDAO.getCategoryByID(categoryID);
	}

	public List<Category> listCategories() {		
		
		List<Category> categories = null;
		// We can add cache logic here 
		try {
			categories = categoryDAO.listCategories();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return categories;
		
	}

	public Category getCategoryByCode(String categoryCode) {
		return this.categoryDAO.getCategoryByCode(categoryCode);
	}
	
}
