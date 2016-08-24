package pages;

import java.util.List;

import org.openqa.selenium.interactions.Actions;

import utils.web.Browsers;
import utils.web.HtmlElement;
import utils.web.PageDriver;
import utils.web.WBy;

public class PresentationPage extends PortalPage{
	
	LoginPage _lp;

    public PresentationPage(PageDriver driver) {
        super(driver);
        this._lp = new LoginPage(driver);
    }

    public boolean getPresentation(String userName,String pwd,String pptName,String pptPwd)
    {
        boolean status = false;
        try {
            _lp.getLoginPage();
            status = _lp.perfromLogin(userName, pwd);
            if (status) {
                Actions action = driver.initializeAction();
                HtmlElement resourceElement = driver.findElement("home:resource");
                resourceElement.mouseOver(action);
                //resourceElement.performClickAndHold(action);
                if(driver.getBrowser() != Browsers.HtmlUnit)
                 driver.getwScreenshot().takeScreenShot(driver._configuration.TakeScreenShot, driver._configuration.ScreenFolderPath);
                clickOnPresentation();
                if(driver.getBrowser() != Browsers.HtmlUnit)
                driver.getwScreenshot().takeScreenShot(driver._configuration.TakeScreenShot, driver._configuration.ScreenFolderPath);
                openPresentation(pptName, pptPwd);
            }
        }
        catch (Exception e)
        {
            status = false;
            _logger.error(e);
        }
        return status;
    }

    public void clickOnPresentation() throws Exception
    {
        List<HtmlElement> elements = (List)driver.findElements("home:resource.list");
        for (HtmlElement element : elements)
        {
            if(element.getAttribute("href").contains("presentations"))
            {
                driver.visibilityWait(WBy.get("link=presentation.text"));
                element.click();
                break;
            }
        }
    }

    public void openPresentation(String pptName, String pptPwd)throws InterruptedException,Exception
    {
        List<HtmlElement> pptElements = (List)driver.findElements("xpath=presentation:list");
        for (HtmlElement ppt : pptElements)
        {
            if(ppt.getText().equalsIgnoreCase(pptName))
            {
                ppt.click();
                driver.getwWindowHandles().windowHandles();
                driver.waitForLoad();
                //driver.visibilityWait(WBy.get("class=presentation.dialog"));
                HtmlElement pwdDialog = driver.findElement("presentation.dialog.input");
                System.out.println(pwdDialog);
                if(pwdDialog != null && pwdDialog.isDisplayed())
                {
                    driver.getwWindowHandles().switchToWindow();
                    if(driver.getBrowser() != Browsers.HtmlUnit)
                    driver.getwScreenshot().takeScreenShot(driver._configuration.TakeScreenShot, driver._configuration.ScreenFolderPath);
                    driver.findElement("presentation.dialog.input").sendKeys(pptPwd);
                    driver.findElement("presentation.dialog.submit").click();
                    HtmlElement downloadLink = driver.findElement("presentation.dialog.download");
                    if(driver.getBrowser() != Browsers.HtmlUnit)
                    driver.getwScreenshot().takeScreenShot(driver._configuration.TakeScreenShot,driver._configuration.ScreenFolderPath);
                    if(downloadLink != null && driver.findElement("presentation.dialog.download").isDisplayed())
                    {
                        driver.findElement("presentation.dialog.download").click();
                    }
                }
                break;
            }
        }

    }
}   
