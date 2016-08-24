package pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.web.Browsers;
import utils.web.PageDriver;
import utils.web.WBy;
import utils.web.WJavascriptExecutor;

public class HomePage extends PortalPage {
	
	public HomePage(PageDriver driver) {
        super(driver);
        _logger.debug("Open Home Page");
        driver.findElement("header.home").click();
    }

    public int getSliderItemsCount() {
    	
       int sliderCount= driver.findElements("home.slider.items").size();
       
       System.out.println("sliders in this homepage is :\n"+sliderCount);
       return sliderCount;
       
    }
    


    public boolean getFacebookPage()
    {
        boolean status = false;
        try{
	        driver.visibilityWait(WBy.get("header.social.fblink"));
            if(driver.getBrowser() != Browsers.HtmlUnit) {
                WebDriver wd = driver.getWebDriver();
                WebElement element = wd.findElement(WBy.get("header.social.fblink"));
                WJavascriptExecutor js = new WJavascriptExecutor(wd, element);
                js.executeScript("arguments[0].click();");
            }
            else
            {
                driver.findElement("header.social.fblink").click();
            }
            String url=driver.getCurrentUrl();
            System.out.println("Current url is "+url);
            status = driver.getCurrentUrl().contains("facebook")?true:false;
        }
        catch(Exception e)
        {
        	_logger.error(e);
        }
        return status;
    }
    
} 
