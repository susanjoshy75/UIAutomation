package pages;

import java.util.List;

import org.openqa.selenium.interactions.Actions;

import utils.web.HtmlElement;
import utils.web.PageDriver;
import utils.web.WBy;
import utils.web.WSelect;

public class RecordingsPage extends PortalPage{
	LoginPage _lp;

    public RecordingsPage(PageDriver driver) {
        super(driver);
        this._lp = new LoginPage(driver);
    }

    public boolean playRecordings(String userName,String pwd,String batch,String topic)
    {
        boolean status = true;
        try {
            _lp.getLoginPage();
            status = _lp.perfromLogin(userName, pwd);
            if (status) {
                Actions action = driver.initializeAction();
                HtmlElement resourceElement = driver.findElement("home:resource");
                resourceElement.performClickAndHold(action);
         //       driver.takeScreenShot();
                clickOnRecordings();
           //     driver.takeScreenShot();
                openRecording(batch, topic);
            }
        }
        catch (Exception e)
        {
            status = false;
            _logger.error(e);
        }
        return status;
    }

    public void clickOnRecordings() throws Exception
    {
        List<HtmlElement> elements = (List)driver.findElements("home:resource.list");
        for (HtmlElement element : elements)
        {
            if(element.getAttribute("href").contains("recordings"))
            {
                driver.visibilityWait(WBy.get("link=recordings.text"));
                element.click();
                break;
            }
        }
    }

    public void openRecording(String batch,String topic)throws Exception
    {
        WSelect batchSelect = new WSelect("id=recordings.batch.id");
        batchSelect.byVisibleText(batch);
        WSelect recordingSelect = new WSelect("id=recordings.recording.id");
        recordingSelect.byVisibleText(topic);

    }

}
