package cr.prodigious.aem.sightlyworkshop.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.io.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cr.prodigious.aem.sightlyworkshop.model.Category;
import cr.prodigious.aem.sightlyworkshop.service.CategoryService;

@SlingServlet(paths = "/bin/prodigious/sightlyworkshop/servlet/categories", methods = "GET")
public class ListCategoriesServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference 
	CategoryService categoryService;

	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
	        throws ServletException, IOException {
		response.setContentType("application/json");
		List<Category> categories = categoryService.listCategories();
		JSONWriter writer = new JSONWriter(response.getWriter());
		try {
			writer.array();
			writer.object();
			writer.key("text").value("All");
			writer.key("value").value(StringUtils.EMPTY);
			writer.endObject();
			Iterator<Category> categoriesIterator = categories.iterator();
			while (categoriesIterator.hasNext()) {
				Category category = categoriesIterator.next();
				writer.object();
				writer.key("text").value(category.getCategoryName());
				writer.key("value").value(category.getCategoryCode());
				writer.endObject();
			}
			writer.endArray();
		} catch (JSONException e) {
			logger.error(e.getMessage());
		}
	}
}