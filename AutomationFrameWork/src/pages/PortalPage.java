package pages;

import java.util.Set;

import utils.web.PageDriver;
import base.BasePage;

	public  abstract class PortalPage extends BasePage {

	    public PortalPage(PageDriver driver) {
	        super(driver);
	    }


	    public String getTitle() {
	        return driver.getTitle();
	    }

	    public boolean isLogoPresent() {
	        return driver.findElements("header.logo").size() > 0;
	    }

	    public boolean areSocialIconsPresent() {
	        return driver.findElements("header.social").size() > 0;
	    }

	    public int getSocialIconsCount() {
	        return driver.findElements("header.social.links").size();
	    }

	    public Set<String> getSocialLinks() {
	        return driver.getLinks("header.social.links");
	        
	    }


	}
	


