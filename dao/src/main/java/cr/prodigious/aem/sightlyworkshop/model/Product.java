package cr.prodigious.aem.sightlyworkshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Product Entity Bean 
 */
@Entity
@Table(name="Product")
public class Product {

	@Id
	@Column(name="productID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productID;
	
	@Column(name = "productSKU", unique=true, nullable=false, length=8)
	private String productSKU;
	
	@Column(name = "productName", nullable=false, length=100)
	private String productName;
	
	@Column(length=300) 
	private String productDescription;
	
	@Column(precision=8, scale=2) 
	private int productPrice;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryID", nullable=false)
	private Category category;

	/**
	 * @return the productID
	 */
	public int getProductID() {
		return productID;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}

	/**
	 * @return the productSKU
	 */
	public String getProductSKU() {
		return productSKU;
	}

	/**
	 * @param productSKU the productSKU to set
	 */
	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the productPrice
	 */
	public int getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productSKU=" + productSKU
				+ ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice
				+ ", category=" + category + "]";
	}
}