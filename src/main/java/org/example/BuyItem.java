package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BuyItem {
    WebDriver driver;


    @FindBy(id = "ui-id-5")
    WebElement mens;

    @FindBy(id="ui-id-17")
    WebElement mensTops;

    @FindBy(id = "ui-id-19")
    WebElement jackets;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span")
    WebElement item;

    @FindBy(id="option-label-size-143-item-168")
    WebElement mSize;

    @FindBy(id="option-label-color-93-item-50")
    WebElement Color;

    @FindBy(id="product-addtocart-button")
    WebElement submit;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div[1]/a")
    WebElement storage;

    @FindBy(id="top-cart-btn-checkout")
    WebElement goToBuy;

    @FindBy(xpath = "//*[@id=\"checkout-step-shipping\"]/div[2]/button")
    WebElement newAddress;

    @FindBy(name="street[0]")
    WebElement StreetAddrFld;

    @FindBy(name="city")
    WebElement CityFld;

    @FindBy(name="region_id")
    WebElement ChooseReg;

    @FindBy(xpath = "//*[@id=\"ICJNQND\"]/option[2]")
    WebElement Alabama;

    @FindBy(name="postcode")
    WebElement Zip;

    @FindBy(name="telephone")
    WebElement Phone;

    @FindBy(xpath = "/html/body/div[2]/aside[2]/div[2]/footer/button[1]")
    WebElement ShipButton;

    @FindBy(name="ko_unique_3")
    WebElement ShipMethod;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
    WebElement NextButton;

    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")
    WebElement PlaceOrder;

    @FindBy(tagName = "h1")
    WebElement afterOrdering;
    public BuyItem(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Clickchoose(){
        Actions actions = new Actions(driver);
        actions.moveToElement(mens).perform();
        actions.moveToElement(mensTops).perform();
        jackets.click();
    }
    public void ClickitemBuy(){
        item.click();
        mSize.click();
        Color.click();
    }
    public void SSiTEM(){
        submit.click();
    }
    public void orderItem(){
        storage.click();
        goToBuy.click();
    }
    public void addNewAddress(){
        newAddress.click();
    }
    public void setStreet(String Straddress) {

        this.StreetAddrFld.sendKeys(Straddress);
    }
    public void setCity(String StrCity) {

        this.CityFld.sendKeys(StrCity);
    }
    public void ChooseReg(){
        Select drpReg = new Select(driver.findElement(By.name("region_id")));
        drpReg.selectByVisibleText("Alabama");
    }
    public void setZip(String StrZip) {

        this.Zip.sendKeys(StrZip);
    }
    public void setPhone(String StrPhone) {

        this.Phone.sendKeys(StrPhone);
    }
    public void ShipSubmit(){
        ShipButton.click();
    }
    public void Order(){
        ShipMethod.click();
        NextButton.click();
    }
    public void PlaceOrder(){
        PlaceOrder.click();
    }
    public void checkOrder(){
        if(afterOrdering.getText().equals( "Thank you for your purchase!")){
            System.out.println("Item ordered");
        }else {
            System.out.println("Error");
        }
    }


}
