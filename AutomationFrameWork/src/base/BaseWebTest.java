package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import utils.ExcelUtils;
import utils.web.PageDriver;
import utils.web.WBy;

public abstract class BaseWebTest extends BaseTest{



    public PageDriver driver;
    public ExcelUtils excelUtils;

    @BeforeSuite
    public void beforeSuite() {
        driver = new PageDriver(_config);
        WBy.loadJsonMap(String.format("%s/locators.json", System.getProperty("user.dir")));
        excelUtils = new ExcelUtils();
    }

    @AfterSuite
    public void afterSuite() {

        driver.quit();
    }
}


