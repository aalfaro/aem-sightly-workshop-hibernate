package cr.prodigious.aem.sightlyworkshop.components.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.adobe.cq.sightly.WCMUse;
import cr.prodigious.aem.sightlyworkshop.model.Product;
import cr.prodigious.aem.sightlyworkshop.service.ProductService;

public class ProductsController extends WCMUse {
	
	private ProductService productService; 
	
	@Override
	public void activate() throws Exception {
		this.productService = this.getSlingScriptHelper().getService(ProductService.class);
	}
	
	public List<Product> getProducts() {
		List<Product> products = null;
		
		String categoryCode = this.getProperties().get("categoryCode", StringUtils.EMPTY);
		
		if(StringUtils.isNotBlank(categoryCode)){
			products = productService.listProductsByCategoryCode(categoryCode);
		}else{
			products = productService.listProducts();
		}
		
		return products;
	}

}