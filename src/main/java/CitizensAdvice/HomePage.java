package CitizensAdvice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    private By _headerMenuList = By.xpath("//ul[@class='nav-list-primary']");
    private By _headerSearchBoxField = By.id("main-header__search__input");
    private By _headerSearchSubmitButton = By.xpath("//button[@class='main-header__search__submit']");



    public void getMainHeaderMenuItemsList(){

        // Get list of the main navigation header menu items

        StringBuilder storage = new StringBuilder();
        java.util.List<WebElement> elements = driver.findElements(_headerMenuList);

        for (WebElement e : elements) {
            storage.append(e.getText());
        }
        String headerMenu = storage.toString();
        System.out.println("---------------------------------------------------------------------");
        System.out.println("The list of the items in main navigation header menu are as : \n" + headerMenu);
        System.out.println("---------------------------------------------------------------------");

    }

    public void searchForAHelpFor (String productName){

        //Type the desired productname in searchbar from header
        Utils.typeText(_headerSearchBoxField, productName);

        //Click on search enter/submit button
        driver.findElement(_headerSearchSubmitButton).click();

        System.out.println("Searching for help related to ..... " + productName);
        System.out.println("    ");
        System.out.println(productName + " related search returned with below options for the user");
    }
}
