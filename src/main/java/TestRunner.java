import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/Features",
        plugin ={ "pretty","json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-reports","junit:target/cucumber-report/Cucumber.xml"})
public class TestRunner {



}
