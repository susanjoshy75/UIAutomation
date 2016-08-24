package test.ui;

import static org.testng.AssertJUnit.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseWebTest;
import pages.PresentationPage;
import utils.web.Browsers;

public class PresentationPageTest extends BaseWebTest{
	private PresentationPage _pp;
    private String sheetName;

    @BeforeTest
    @Parameters("sheetName")
    public void init(String sheetName)
    {
        _pp = new PresentationPage(driver);
        this.sheetName = sheetName;
    }
    @DataProvider(name = "ppt-data")
    public Object[][] getUsers() throws Exception {
        Object[][] data = excelUtils.getSimpleExcelData(driver._configuration.DataFilePath,sheetName);
        return data;
    }

    @Test(priority = 1,dataProvider = "ppt-data")
    public void testPresentations(String uname,String pwd,String pptName,String pptPwd) throws InterruptedException,Exception
    {
        boolean actual = _pp.getPresentation(uname, pwd, pptName, pptPwd);
        assertTrue(actual);
        if(driver.getBrowser() != Browsers.HtmlUnit)
        driver.getwScreenshot().takeScreenShot(driver._configuration.TakeScreenShot,driver._configuration.ScreenFolderPath);
    }

    @AfterTest
    public void close()
    {
        driver.close();
    }

}
