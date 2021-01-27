package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Login']")
    private AndroidElement loginButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='SignUp']")
    private AndroidElement signUpButton;
    @FindBy(xpath = "//*[@class='android.widget.EditText' and @text='Email']")
    private AndroidElement emailField;
    @FindBy(xpath = "//*[@class='android.widget.EditText' and @text='Password']")
    private AndroidElement passwordField;
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='LOGIN']")
    private AndroidElement confirmLogginButton;



    public LoginPage(AndroidDriver driver) {
        super(driver);
    }


    public void loginUser(String email,String password){
        loginButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmLogginButton.click();
    }
}
