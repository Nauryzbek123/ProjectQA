package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoBasket {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[1]")
    WebElement addToWishList;

    @FindBy(linkText = "here")
    WebElement ItemAdded;

    public AddtoBasket(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void addToWish(){
        addToWishList.click();
    }
    public void checkWish(){
        if(ItemAdded.getText().equals( "here")){
            System.out.println("Item added to wish list");
        }else {
            System.out.println("Error");
        }
    }
}
