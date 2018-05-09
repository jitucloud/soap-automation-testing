package com.esdc.automation.StepDefinations;
import com.esdc.automation.queryAppointment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class queryAppointmentSteps {
    private queryAppointment _target;
    private String _actualResult;
    @Given("^I am officiating a FizzBuzz game1$")
    public void I_am_officiating_a_FizzBuzz_game() {
        _target = new queryAppointment();
    }
    @When("^the number (\\d+) is played1$")
    public void the_number_is_played(int playedNumber) {
        _actualResult = _target.checkPlay123(playedNumber);
    }
    @Then("^I should be told the correct answer is1 \"([^\"]*)\"$")
    public void I_should_be_told_the_correct_answer_is(String expectedResult) {
        assertEquals(expectedResult, _actualResult);
    }
}
