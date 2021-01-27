import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;

public class Tests extends BaseTest{

    private final String username = fileUtils.getRandomAlphaNumString(8)+ "@" + fileUtils.getRandomAlphaNumString(5) +".com" ;
    private final String password = fileUtils.getRandomAlphaNumString(8);


    @Test
    public void SignInTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnPage("Login");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpUser(username,password);
        Assert.assertTrue(signUpPage.getAlertMessage().contains("You successfully signed up!"));

    }
    @Test
    public void LogInTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnPage("Login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("keeptest@test.com","keeptest");
        Assert.assertTrue(loginPage.getAlertMessage().contains("You are logged in!"));

    }
    @Test
    public void FormTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnPage("Forms");
        FormPage formPage = new FormPage(driver);
        formPage.fillForm("Appium is awesome");

    }

    @Test
    public void WebviewTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnPage("Webview");
        WebViewPage webViewPage = new WebViewPage(driver);
        webViewPage.searchonWebView();
        webViewPage.navigateOnWebView();

    }


}
