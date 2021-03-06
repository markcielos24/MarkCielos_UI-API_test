package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
        glue= {"StepsDefinitions"},
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/HTMLReports.html",
                "json:target/cucumber.json",
                "junit:target/XMLreports.xml"}
        , tags="@UI"
)

public class TestRunner {
}
