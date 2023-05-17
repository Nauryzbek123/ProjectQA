package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Main {
    WebDriver driver;
    LoginInto loginInto;
    BuyItem buyItem;
    AddtoBasket addtoBasket;

    SearchItem searchItem;
    ProfileInfo profileInfo;
    @BeforeTest()
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://magento.softwaretestingboard.com");

    }
    @Test()
    public void setLoginInto() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
      loginInto = new LoginInto(driver);
      loginInto.setUserName("nauryzbekdias@gmail.com");
      loginInto.setPassword("Barcelona2603");
      loginInto.clickLoginBtn();
        Thread.sleep(5000);
        loginInto.clickProf();
        loginInto.clickSignOut();

    }
    @Test(priority = 1)
    public void setBuyItem() throws InterruptedException{
        loginInto = new LoginInto(driver);
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
        loginInto.setUserName("nauryzbekdias@gmail.com");
        loginInto.setPassword("Barcelona2603");
        loginInto.clickLoginBtn();
        Thread.sleep(5000);
        buyItem = new BuyItem(driver);
        buyItem.Clickchoose();
        buyItem.ClickitemBuy();
        buyItem.SSiTEM();
        Thread.sleep(5000);
        buyItem.orderItem();
        Thread.sleep(10000);
        buyItem.addNewAddress();
        Thread.sleep(1000);
        buyItem.setStreet("DD REREWWewe");
        buyItem.setCity("Disaa");
        buyItem.ChooseReg();
        Random random = new Random();
        buyItem.setZip("12345-6784");
        buyItem.setPhone(random.nextInt(2000) + "12123");
        buyItem.ShipSubmit();
        buyItem.Order();
        Thread.sleep(5000);
        buyItem.PlaceOrder();
        Thread.sleep(5000);
        buyItem.checkOrder();
    }
    @Test(priority = 2)
    public void setAddToWish() throws InterruptedException{
        loginInto = new LoginInto(driver);
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
        loginInto.setUserName("nauryzbekdias@gmail.com");
        loginInto.setPassword("Barcelona2603");
        loginInto.clickLoginBtn();
        Thread.sleep(5000);
        buyItem = new BuyItem(driver);
        buyItem.Clickchoose();
        buyItem.ClickitemBuy();
        addtoBasket = new AddtoBasket(driver);
        addtoBasket.addToWish();
        Thread.sleep(5000);
        addtoBasket.checkWish();

    }
    @Test(priority = 3)
    public void setSearchBar() throws InterruptedException{
        searchItem = new SearchItem(driver);
        searchItem.setSearchItem("Marco Lightweight Active Hoodie");
        searchItem.SearchSubmit();
        searchItem.checkSearch();
    }
    @Test(priority = 4)
    public void setProfileData() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
        loginInto = new LoginInto(driver);
        loginInto.setUserName("nauryzbekdias@gmail.com");
        loginInto.setPassword("Barcelona2603");
        loginInto.clickLoginBtn();
        Thread.sleep(5000);
        loginInto.clickProf();
        profileInfo = new ProfileInfo(driver);
        profileInfo.clickMyAccount();
        profileInfo.clickEditName();
        profileInfo.setFirstName("DSDSSD");
        profileInfo.setLastName("JDSJJH");
        profileInfo.clickSave();
        Thread.sleep(10000);
        profileInfo.checkInfo();
    }

}