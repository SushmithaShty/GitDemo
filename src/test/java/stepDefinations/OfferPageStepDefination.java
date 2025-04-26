package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.*;

import pageObjects.OffersPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class OfferPageStepDefination {

    TestContextSetup testContextSetup;
    OffersPage offersPage;
    String offerPageProductName;

    public OfferPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.offersPage = testContextSetup.pageObjectManager.getOfferPage();
    }

    @Then("^user searched for the (.+) shortname in offers page$")
    public void user_searched_for_the_shortname_in_offers_page(String shortName) throws InterruptedException {
        switchToOffersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = offersPage.getProductName();
        System.out.println("Offer page product name: " + offerPageProductName);
    }

    public void switchToOffersPage() {
        LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchWindowToChild();
    }
    
    @And("validate product name in offers page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() 
    {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageproductName,
                "Mismatch between product names in Offers and Landing pages");
    }
}
