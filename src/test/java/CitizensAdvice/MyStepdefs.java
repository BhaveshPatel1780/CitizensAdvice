package CitizensAdvice;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static CitizensAdvice.BasePage.driver;

public class MyStepdefs {

    GoogleSearchPage googlesearch = new GoogleSearchPage();
    HomePage homepage = new HomePage();
    SearchPage searchpage = new SearchPage();


    @Given("^I am Google search page$")
    public void iAmGoogleSearchPage()  {

        googlesearch.userIsOnGoogleSearchPage();
    }

    @And("^I search for 'Citizens Advice'$")
    public void iSearchForCitizensAdvice()  {

        googlesearch.searchCitizensAdviceOnGoogle();
    }

    @When("^I navigate to Citizens Advice homepage$")
    public void iNavigateToCitizensAdviceHomepage()  {

        googlesearch.navigateToCitizensAdviceHomepage();
    }

    @Then("^I should able to see a list of items on main navigation header on the homepage$")
    public void iShouldAbleToSeeAListOfItemsOnMainNavigationHeaderOnTheHomepage()  {

        homepage.getMainHeaderMenuItemsList();
    }

    @When("^I search for \"([^\"]*)\" related help on the homepage$")
    public void iSearchForRelatedHelpOnTheHomepage(String productName) throws Throwable {

        homepage.searchForAHelpFor(productName);

    }


    @Then("^I should able to verify \"([^\"]*)\" link in search result$")
    public void iShouldAbleToVerifyLinkInSearchResult(String linkName) throws Throwable {

        Assert.assertTrue(searchpage.verifyLinkInSearchList(linkName));
        System.out.println(" ");
        System.out.println("---------------------------------------------------------");
        System.out.println(linkName + " link is present in the search list");
        System.out.println("---------------------------------------------------------");
    }


}
