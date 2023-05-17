package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileInfo {
    WebDriver driver;
    @FindBy(linkText = "My Account")
    WebElement MyAccount;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/a[1]")
    WebElement editName;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement save;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
    WebElement SavedMesage;
    public ProfileInfo(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickMyAccount(){
        MyAccount.click();
    }
    public void clickEditName(){
        editName.click();
    }
    public void setFirstName(String StrFirstName) {

        this.firstName.sendKeys(StrFirstName);
    }
    public void setLastName(String StrLastName) {

        this.lastName.sendKeys(StrLastName);
    }
    public void clickSave(){
        save.click();
    }
    public void checkInfo(){
        if(SavedMesage.getText().equals( "You saved the account information.")){
            System.out.println("Profile info changed");
        }else {
            System.out.println("Error");
        }
    }
}
