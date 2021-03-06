/**
 * AEM Sightly Workshop Components Model package.
 */
package cr.prodigious.aem.sightlyworkshop.components.model;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

/**
 * Entity class for the Modal.
 * 
 * @author Rodolfo Oviedo
 */
@Model(adaptables = Resource.class)
public class Modal {

	/**
	 * Class attributes.
	 */
	@Inject
	private String title;
	
	@Inject
	private String message;
	
	@Inject
	private String closeTitle;
	
	@Inject
	private String buttonTitle;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the closeTitle
	 */
	public String getCloseTitle() {
		return closeTitle;
	}

	/**
	 * @param closeTitle
	 *            the closeTitle to set
	 */
	public void setCloseTitle(String closeTitle) {
		this.closeTitle = closeTitle;
	}

	/**
	 * @return the buttonTitle
	 */
	public String getButtonTitle() {
		return buttonTitle;
	}

	/**
	 * @param buttonTitle
	 *            the buttonTitle to set
	 */
	public void setButtonTitle(String buttonTitle) {
		this.buttonTitle = buttonTitle;
	}

	/**
	 * Method to return if the component has a valid configuration.
	 * 
	 * @return Result of the operation
	 */
	public boolean isConfigValid() {
		return StringUtils.isNotBlank(title) && StringUtils.isNotBlank(message)
				&& StringUtils.isNotBlank(closeTitle)
				&& StringUtils.isNotBlank(buttonTitle);
	}

}
