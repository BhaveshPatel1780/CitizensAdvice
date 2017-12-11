package CitizensAdvice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SearchPage extends BasePage {

    private By _searchPageTitleField = By.className("page-title");
    private By _searchResultList = By.xpath("//ul[@class='search-results']/li/h3/a");






    public boolean verifyLinkInSearchList(String linkToBeChecked) {

        //Verifying if user is navigated to correct page - which is Search Page
        Assert.assertTrue(Utils.getTextFromElement(_searchPageTitleField).contains("Search"), "User is not on search result page");

        // Get the list for searched product
        WebElement searchresultcontainer = driver.findElement(By.className("search-results"));
        java.util.List<WebElement> searchresultlist = searchresultcontainer.findElements(_searchResultList);
        java.util.Iterator<WebElement> x = searchresultlist.iterator();
        System.out.println("  ");
        while (x.hasNext()) {
            WebElement searchlistitem = x.next();
            System.out.println(searchlistitem.getText());
        }

        // Checking if desired link is present in the searchlist text
        for (WebElement e : searchresultlist)
            if (e.getText().trim().equals(linkToBeChecked)) {
                return true;
            }
        return false;
    }
}
