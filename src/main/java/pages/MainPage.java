package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageObject {
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Login']")
    private AndroidElement loginButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Forms']")
    private AndroidElement formsButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='WebView']")
    private AndroidElement webviewButton;

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOnPage(String page) {
        switch (page) {
            case "Login":
                loginButton.click();
                break;
            case "Forms":
                formsButton.click();
                break;
            case "Webview":
                webviewButton.click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + page);
        }
    }
}
