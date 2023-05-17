package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItem {
    WebDriver driver;
    //Marco Lightweight Active Hoodie
    @FindBy(css = "input#search")
    WebElement ItemSearch;
    @FindBy(xpath = "//*[@id=\"search_mini_form\"]/div[2]/button")
    WebElement ItemSearchSubmit;

    @FindBy(partialLinkText = "Marco Lightweight Active")
    WebElement ItemSearched;

    public SearchItem(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setSearchItem(String StrItemName) {

        this.ItemSearch.sendKeys(StrItemName);
    }
    public void SearchSubmit(){
        ItemSearchSubmit.click();
    }
    public void checkSearch(){
        if(ItemSearched.getText().equals( "Marco Lightweight Active Hoodie")){
            System.out.println("Search bar works correctly");
        }else {
            System.out.println("Error");
        }
    }

}
