package test.ui;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import utils.web.Browsers;
import base.BaseWebTest;

public class HomePageTest extends BaseWebTest{
	
	 private HomePage _hp;

	    @BeforeClass
	    public void beforeClass() {
	        _hp = new HomePage(driver);
	    }
	    
	    @Test(priority=6)
	    public void getDriver(){
	    	String title=_hp.getTitle();
	    	System.out.println("title is "+title);
	    }
	    
	    @Test(priority = 1, alwaysRun = true)
	    public void testSlidesCount() throws IOException{
	    
	    if(driver.getBrowser() != Browsers.HtmlUnit)
	     driver.getwScreenshot().takeScreenShot(driver._configuration.TakeScreenShot, driver._configuration.ScreenFolderPath);
	    assertEquals(8, _hp.getSliderItemsCount());
	   }

	    @Test(priority = 5)
	    public void testFBLink()
	    {
	        boolean isFBPage = _hp.getFacebookPage();
	        System.out.println("is fb page exists :"+isFBPage);
	        assertTrue(isFBPage);
	    }
	    @Test(priority=2)
	    public void isSocialIconPresent(){
	    	
	    	boolean status=_hp.areSocialIconsPresent();
	    	System.out.println("social icon present or not  :"  +status);
	    	assertEquals(true,_hp.areSocialIconsPresent());
	    }
	    @Test(priority=3)
	    public void socialCount(){
	    	int count=_hp.getSocialIconsCount();
	    	System.out.println("The number of social icons are : "+count);
	    	assertEquals(4,_hp.getSocialIconsCount());
	    	
	    	
	    	
	    }
	    
	    @Test(priority=4)
	    public void logoPresent(){
	    	boolean logo=false;
	    	logo=_hp.isLogoPresent();
	    	
	    	assertTrue(logo);
	    	
	    }	

	}


