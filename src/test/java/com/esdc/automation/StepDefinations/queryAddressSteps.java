package com.esdc.automation.StepDefinations;
import nbn.com.cis.queryAddress;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.AssertJUnit.assertEquals;

public class queryAddressSteps {
    private queryAddress _target;
    private String _actualResult;
    @Given("^I am officiating a FizzBuzz game$")
    public void I_am_officiating_a_FizzBuzz_game() {
        _target = new queryAddress();
    }
    @When("^the number (\\d+) is played$")
    public void the_number_is_played(int playedNumber) {
        _actualResult = _target.checkPlay(playedNumber);
    }
    @Then("^I should be told the correct answer is \"([^\"]*)\"$")
    public void I_should_be_told_the_correct_answer_is(String expectedResult) {
        assertEquals(expectedResult, _actualResult);
    }
}
