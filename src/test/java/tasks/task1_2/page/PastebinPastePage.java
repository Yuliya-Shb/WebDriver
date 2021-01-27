package tasks.task1_2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PastebinPastePage extends AbstractPage {

    public PastebinPastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitlePaste() {
        return getElementPage(By.xpath("//div[@class='info-top']/h1")).getText();
    }

    public String getSyntax() {
        return getElementPage(By.xpath("//div[@class='top-buttons']/div[@class='left']/a")).getText();
    }

    public String getPasteContent() {
        return getElementPage(By.xpath("//div[@class='post-view']/textarea[@class='textarea']")).getText();
    }

    public PastebinPastePage openPage() {
        throw new RuntimeException("Error Pastebin Page");
    }
}
