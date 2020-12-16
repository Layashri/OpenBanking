import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin ={ "pretty","json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber-html-report",
                "junit:target/cucumber-reports/cucumber.xml"},tags = "@regression")
public class TestRunner {

}
