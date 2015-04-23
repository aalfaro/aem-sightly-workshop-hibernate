package cr.prodigious.aem.sightlyworkshop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category Entity Bean 
 */
@Entity
@Table(name="Category")
public class Category {

	@Id
	@Column(name="categoryID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryID;
	
	@Column(name="categoryCode", unique=true, nullable=false)
	private String categoryCode;
	
	@Column(length=100) 
	private String categoryName;
	
	@Column(length=300) 
	private String categoryDescription;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "category")
	private Set<Product> products = new HashSet<Product>(0);

	/**
	 * @return the categoryID
	 */
	public int getCategoryID() {
		return categoryID;
	}

	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryCode the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryDescription
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}

	/**
	 * @param categoryDescription the categoryDescription to set
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	/**
	 * @return the products
	 */
	public Set<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryCode="
				+ categoryCode + ", categoryName=" + categoryName
				+ ", categoryDescription=" + categoryDescription + "]";
	}
}