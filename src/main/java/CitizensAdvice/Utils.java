package CitizensAdvice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage{

    //re-usable method for click on Element
    public static void clickOnElement(By by){

        driver.findElement(by).click();
    }

    // re-usable method for typing text into element (instead of sendKeys())
    public static void typeText(By by, String text){
        //clearing any existing text from the element
        driver.findElement(by).clear();
        //sending your text to the locator by
        driver.findElement(by).sendKeys(text);
    }


    public static void assertTrueByElementDisplayed(By by){
        Assert.assertTrue(driver.findElement(by).isDisplayed(), "No such element has been displayed");
    }


    public static void assertTrueByContainsString(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text),"User not on "+text+" page");
    }


    //Reusable method for getText
    public static String getTextFromElement(By by){     //return type as String - why? to store and return the test we are receving from the element
        String text =  driver.findElement(by).getText();                                                          // so we can reuse the text
        return text;
    }


    public static void keyEnter(By by){

        driver.findElement(by).sendKeys(Keys.ENTER);

    }

}
