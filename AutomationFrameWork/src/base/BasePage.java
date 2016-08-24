package base;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import utils.web.PageDriver;

public abstract class BasePage {
	public Logger _logger;
    public PageDriver driver;

    public BasePage(PageDriver driver) {
        _logger = Logger.getLogger(BaseTest.class);
        this.driver = driver;
	
}
}