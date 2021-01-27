package tasks.task1_2.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tasks.task1_2.page.PastebinHomePage;
import tasks.task1_2.page.PastebinPastePage;

public class Task2WebDriverPastebinTest {
    private WebDriver driver = new ChromeDriver();
    private String titlePaste = "how to gain dominance among developers";
    private String textPaste = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String syntaxPaste = "Bash";
    private PastebinPastePage pastePage;

    @BeforeClass
    public void init() {
        pastePage = new PastebinHomePage(this.driver)
                .openPage()
                .createNewPaste(textPaste, syntaxPaste, "10 Minutes", titlePaste);
    }

    @Test(description = "Create Paste")
    public void checkTitlePaste() {
        Assert.assertEquals(pastePage.getTitlePaste(), titlePaste);
    }

    @Test(description = "Create Paste")
    public void checkSyntaxPaste() {
        Assert.assertEquals(pastePage.getSyntax(), syntaxPaste);
    }

    @Test(description = "Create Paste")
    public void checkContentPaste() {
        Assert.assertEquals(pastePage.getPasteContent(), textPaste);
    }

    @AfterClass
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
