package com.esdc.automation;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.Test;

@CucumberOptions(features = "src/test/resources/features", plugin = "json:target/cucumber-report-composite.json")
public class RunCukesByCompositionTest {

    @Test(groups = "examples-testng", description = "Example of using TestNGCucumberRunner to invoke Cucumber")
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}