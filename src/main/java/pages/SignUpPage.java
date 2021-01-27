package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class SignUpPage extends PageObject{
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Login']")
    private ArrayList<AndroidElement> loginButton;
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Sign up']")
    private AndroidElement signUpButton;
    @FindBy(xpath = "//*[@class='android.widget.EditText' and @text='Email']")
    private AndroidElement emailField;
    @FindBy(xpath = "//*[@class='android.widget.EditText' and @text='Password']")
    private AndroidElement passwordField;
    @FindBy(xpath = "//*[@class='android.widget.EditText' and @text='Confirm password']")
    private AndroidElement confirmPasswordField;
    @FindBy(xpath = "//*[@class='android.widget.TextView' and @text='SIGN UP']")
    private AndroidElement confirmSignUpButton;
    @FindBy(id = "message")
    private AndroidElement message;

    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }

    public void signUpUser(String email,String password){
        signUpButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        confirmSignUpButton.click();
    }



}
