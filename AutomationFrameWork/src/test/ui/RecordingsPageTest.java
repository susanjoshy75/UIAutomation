package test.ui;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.RecordingsPage;
import base.BaseWebTest;

public class RecordingsPageTest extends BaseWebTest{
	 private RecordingsPage _rp;
	    private String sheetName;

	    @BeforeTest
	    @Parameters("sheetName")
	    public void init(String sheetName)
	    {
	        _rp = new RecordingsPage(driver);
	        this.sheetName = sheetName;
	    }

	    @DataProvider(name = "recording-data")
	    public Object[][] getUsers() throws Exception {
	        Object[][] data = excelUtils.getSimpleExcelData(driver._configuration.DataFilePath,sheetName);
	        return data;
	    }

	    @Test(priority = 1,dataProvider = "recording-data")
	    public void testRecordings(String uname,String pwd,String batch,String recording) throws InterruptedException,Exception
	    {
	        boolean actual = _rp.playRecordings(uname, pwd, batch, recording);
	       // assertTrue(actual);
	      //  driver.takeScreenShot();
	    }

	    @AfterTest
	    public void close()
	    {
	        driver.close();
	    }
	

}
