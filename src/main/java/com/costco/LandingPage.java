package com.costco;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Finding the loactors

    @FindBy(xpath = "//div[@class='MuiBox-root mui-saptuz']//img[@alt='Costco US homepage']") WebElement logo;
    @FindBy(xpath = "//div[@class='MuiBox-root mui-1nzpdry']") WebElement allLinks;
    @FindBy(xpath = "//input[@id=':r1:']") WebElement searchbox;
    @FindBy(xpath = "//button[@aria-label='Search']//*[name()='svg']") WebElement searchbutton;
    @FindBy(xpath = "//h1[normalize-space()='Computers']") WebElement computer;

    public String verifyCostcoLogo(){
        return logo.getText();
    }

    public void verifyAllLinks(){
        logo.isDisplayed();
    }

    public void  searchItem(String item){
        searchbox.sendKeys(item);
        searchbutton.click();
    }
public String verifySearchResult(){
        return computer.getText();
}






}