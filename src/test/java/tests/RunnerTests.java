package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@login"

)
public class RunnerTests extends AbstractTestNGCucumberTests {
    @Test
    public void runCucumberTests() {

    }
}