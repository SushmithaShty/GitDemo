package stepDefinations;

import io.cucumber.java.en.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefination {

    TestContextSetup testContextSetup;
    LandingPage landingPage;

    public LandingPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("User is On the GreenCart Landing Page")
    public void user_is_on_the_green_cart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User Searched with ShortName (.+) and extract the Actual Name of the Product$")
    public void user_searched_with_short_name_and_extract_the_actual_name_of_the_product(String shortName) throws InterruptedException {
        landingPage.searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageproductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println("Landing page product name: " + testContextSetup.landingPageproductName);
    }

    @And("^Added (.+) items of the selected product to the cart$")
    public void added_items_of_the_selected_product_to_the_cart(String quantity) {
        landingPage.incrementQuantity(Integer.parseInt(quantity));
        landingPage.addToCart();
    }
}
