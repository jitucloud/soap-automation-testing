package com.esdc.automation;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@Cucumber.Options(
        features={"src/test/resources/features"}
)

public class CukesRunner {
}
