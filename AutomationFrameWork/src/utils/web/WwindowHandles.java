package utils.web;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;

public class WwindowHandles {
	
	WebDriver _webDriver;

    public WwindowHandles(WebDriver driver)
    {
        this._webDriver = driver;
    }

    public void switchToWindow()
    {
        String newWindow = _webDriver.getWindowHandle();
        _webDriver.switchTo().window(newWindow);
    }



    public void windowHandles()
    {
        Iterator<String> handles = _webDriver.getWindowHandles().iterator();
        while(handles.hasNext()){
            String child = handles.next();
            _webDriver.switchTo().window(child);
        }
    }




}
