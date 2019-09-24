import com.deque.axe.AXE;
import common.AbstractDriverManager;
import common.DriverManagerFactory;
import common.DriverType;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.net.URL;
import java.sql.Driver;

/**
 * Created by Chandandeep Singh on 03-03-2019.
 */
public class BaseTest {

    AbstractDriverManager driverManager;
    WebDriver driver;
    private static final URL scriptUrl = BaseTest.class.getResource("/axe.min.js");

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

   @AfterMethod
    public void afterMethod() {
        driverManager.closeDriver();
    }

    @Test
    public void launchTestAutomationGuruTest() {
        driver.get("http://automationpractice.com/index.php");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadPage(LoginPage.class).clickOnSignIn()
        .enterEmail("a@a.com")
        .enterPassword("12345")
        .clickSignInButton();
    }

    @Test
    public void launchTestAutomationGuruTest1() {
        driver.get("http://automationpractice.com/index.php");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadPage(LoginPage.class).clickOnSignIn()
                .enterEmail("a@a.com")
                .enterPassword("12345")
                .clickSignInButton();
    }

    @Test
    public void testAccessibility() {
        driver.get("http://google.com");
        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            Assert.assertTrue(true, "No violations found");
        } else {
            System.out.println(violations.get(1));
        }
    }

}
