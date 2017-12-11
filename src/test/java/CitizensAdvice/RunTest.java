package CitizensAdvice;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = ".",
                 format = {"html:target/CucumberReport", "json:CucumberReport/cucumber.json"},
                 tags = "@search",
                 glue = "CitizensAdvice")

public class RunTest {
}
