package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class LoginInto {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement userEmFld;

    @FindBy(id = "pass")
    WebElement passwordFld;

    @FindBy(name = "send")
    WebElement loginBtn;

    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")
            WebElement profile;

    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    WebElement signOut;

    public LoginInto(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userName) {
        this.userEmFld.sendKeys(userName);
    }

    public void setPassword(String password) {
        this.passwordFld.sendKeys(password);
    }


    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void clickProf(){
        profile.click();
    }
    public void clickSignOut(){
        signOut.click();
    }

}

