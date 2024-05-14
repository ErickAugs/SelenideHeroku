package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinition", "steps"},
        plugin = {"pretty", "json:target/cucumber-report.json"} // Removido o plugin do ExtentReports
)
public class RunnerTest {

}
