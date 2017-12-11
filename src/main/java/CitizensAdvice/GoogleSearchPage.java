package CitizensAdvice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class GoogleSearchPage extends Utils {

    private By _googleSearchBoxField = By.xpath("//input[@title='Search']");
    private By _googleSearchSubmitButton = By.xpath("//center/input[@type='submit']");
    private By _citizensAdviceLink = By.xpath("//h3/a[contains(.,'Citizens Advice')]");
    private By _citizensAdviceHomeWelcomeMessageField = By.xpath("//div/h1[contains(.,'Welcome to Citizens Advice')]");


    public void userIsOnGoogleSearchPage(){
        //User is navigating to Google homepage
        driver.get("https://www.google.co.uk/");
    }

    public void searchCitizensAdviceOnGoogle(){

        //Enter 'Citizen Advice' in Google search box
        Utils.typeText(_googleSearchBoxField,"Citizens Advice");

        //Submit Google Search Button
        Utils.keyEnter(_googleSearchSubmitButton);

        System.out.println("Searching for Citizens Advice in Google............");

    }

    public void navigateToCitizensAdviceHomepage(){

        //click on the 'Citizens Advice' link from google search list
        Utils.clickOnElement(_citizensAdviceLink);

        //Selecting 'England' as desired country
        selectYourDesiredCountry("England");

        //Verifying if user is on correct page i.e. Citizens Advice Homepage
        Assert.assertTrue(driver.findElement(_citizensAdviceHomeWelcomeMessageField).getText().contains("Welcome to Citizens Advice"),"User is NOT on Citizens Advice homepage");

        System.out.println("User has been successfully navigated to Citizens Advice Homepage");
    }

    public void selectYourDesiredCountry(String countryName){

        //Click on your desired country
        driver.findElement(By.xpath("//div[@class='home-extent-popup__options']/a[contains(.,'"+countryName+"')]")).click();

    }

}
