package stepDefinations;

import org.junit.Assert;

import io.cucumber.java.en.*;

import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefination {

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;

    public CheckoutPageStepDefination(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckOutPage();
    }

    @Then("^User procceds to Checkout and validates the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validates_items(String name) throws InterruptedException {
        checkoutPage.CheckoutItems();
        Thread.sleep(2000);
        String checkoutProductName = checkoutPage.getProductName();
        Assert.assertTrue(checkoutProductName.contains(name));
    }

    @And("verify user has ability to enter promo code and place the order")
    public void verify_user_can_enter_promo_code_and_place_order() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }
}
