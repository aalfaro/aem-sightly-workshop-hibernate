package cr.prodigious.aem.sightlyworkshop.service;

import java.util.List;

import cr.prodigious.aem.sightlyworkshop.model.Category;

public interface CategoryService {
	
	void addCategory(Category category);
	
	void updateCategory(Category category);
	
	void removeCategory(int categoryID);
	
	Category getCategoryByID(int categoryID);
	
	List<Category> listCategories();
	
	Category getCategoryByCode(String categoryCode);

}
