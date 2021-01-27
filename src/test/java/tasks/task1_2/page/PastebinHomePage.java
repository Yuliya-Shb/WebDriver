package tasks.task1_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

public class PastebinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement pasteInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationSelect;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxSelect;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(className = "js-create-form")
    private WebElement pasteForm;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public PastebinPastePage createNewPaste(
            String pasteContent,
            String syntax,
            String expiration,
            String pasteName
    ) {
        pasteInput.sendKeys(pasteContent);

        if(!syntax.isEmpty()) {
            syntaxSelect.click();
            WebElement syntaxItem = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(By
                                    .xpath("//*[@id='select2-postform-format-results']/li/ul/li[contains(text(), '" + syntax + "')]")));
            syntaxItem.click();
        }

        if(!expiration.isEmpty()) {
            expirationSelect.click();
            WebElement expirationItem = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(By
                                    .xpath("//*[@id='select2-postform-expiration-results']/li[contains(text(), '" + expiration + "')]")));
            expirationItem.click();
        }

        pasteNameInput.sendKeys(pasteName);
        pasteForm.findElement(By.xpath(".//button[@type='submit']")).click();

        return new PastebinPastePage(driver);
    }
}