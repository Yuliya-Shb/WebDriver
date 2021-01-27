package tasks.task1_2.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tasks.task1_2.page.PastebinHomePage;

public class Task1WebDriverPastebinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test(description = "Create Paste")
    public void commonCreatePaste() {

        String pasteTitle = new PastebinHomePage(this.driver)
                .openPage()
                .createNewPaste("Hello from WebDriver", "", "10 Minutes", "helloweb")
                .getTitlePaste();

        Assert.assertEquals(pasteTitle, "helloweb");
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
