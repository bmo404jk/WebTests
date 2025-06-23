package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.fabricManager.FabricManager;

@Listeners({TestResultListener.class})
public class BaseTest{
    private WebDriver driver;
    private final String BASE_URL = "https://testpages.eviltester.com/styled/";
    protected FabricManager fabricManager = new FabricManager();

    @BeforeSuite
    public static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @BeforeTest
    public void initTests(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "800x600";
        Configuration.baseUrl = BASE_URL;
        Configuration.screenshots = true;
    }

    @AfterSuite()
    public void tearDownSuite() {
        try {
            AllureListener.openAllureReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}