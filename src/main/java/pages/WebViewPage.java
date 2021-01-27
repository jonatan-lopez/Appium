package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class WebViewPage extends PageObject{
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Login']")
    private ArrayList<AndroidElement> loginButton;

    public WebViewPage(AndroidDriver driver) {
        super(driver);
    }

    public void searchonWebView(){
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.webkit.WebView")));
        Set<String> availableContexts = driver.getContextHandles();
        for(String context : availableContexts) {
            if(context.contains("WEBVIEW")){
                driver.context(context);
                break;
            }
        }
        driver.findElement(By.xpath("//span[@class='algolia-autocomplete']")).sendKeys("browser");
    }
    public void navigateOnWebView(){
        ArrayList<String> locators = new ArrayList<>(Arrays.asList("Docs","API","Help","Versions","Blogs","Contribute"));
        locators.forEach(it->driver.findElement(By.xpath("//*[contains(text(),'"+it+"')]")).click());


    }
}
