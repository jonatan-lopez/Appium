package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class FormPage extends PageObject{
    @FindBy(xpath = "//*[@class='android.widget.EditText' and @text='Type something']")
    private AndroidElement inputField;
    @FindBy(xpath= "//*[@class='android.widget.Switch']")
    private AndroidElement switchForm;
    @FindBy(xpath = "//*[@content-desc='select-Dropdown']")
    private AndroidElement dropdown;
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Active']")
    private AndroidElement activeButton;
    @FindBy(xpath = "//*[@class='android.widget.Button' and @text='OK']")
    private AndroidElement oKButton;

    public FormPage(AndroidDriver driver) {
        super(driver);
    }

    public void fillForm(String dropdownOption){
        inputField.sendKeys(fileUtils.getRandomAlphaNumString(8));
        switchForm.click();
        dropdown.click();
        driver.findElement(By.xpath("//*[@text='"+dropdownOption+"']")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Active\").instance(0))").click();
        oKButton.click();
    }
}
