package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions (
		features = "Features",
		plugin = {"pretty", "html:target/cucumber-reports",
				   "json:target/cucumber-reports/Cucumber.json",
				   "junit:target/cucumber-reports/Cucumber.xml",
				  },
		glue = {"Test"}
)
//public class CCmbrRunner extends AbstractTestNGCucumberTests {
public class CCmbrRunner {
	
	
}
