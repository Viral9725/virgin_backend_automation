package com.virgingames.cucumber.steps;

import com.virgingames.jackpotBingo.JackpotBingo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class StepDefs {

    static ValidatableResponse response;
    float amount;
    @Steps
    JackpotBingo jackpotBingo;

    @When("^I send GET request to list endpoint$")
    public void iSendGETRequestToListEndpoint() {
        response = jackpotBingo.getJackpotBingo();
        amount = response.extract().jsonPath().get("data.pots[0].amount");
    }

    @And("^I must get back valid status code (\\d+)$")
    public void iMustGetBackValidStatusCode(int arg0) {
        response.statusCode(200);
    }

    @Then("^I verify amount is not negative$")
    public void iVerifyAmountIsNotNegative() {
        Assert.assertTrue("Amount is negative", amount > 0);
    }

}
