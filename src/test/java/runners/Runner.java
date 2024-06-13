package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",//prints colored logs to the console
                "html:target/reports/default-cucumber-reports.html"
        },
        features = "src/test/resources/features",
        glue = {"stepdefinitions", "base_urls"},//Java kodlarının çalışacağı package'lar.
        tags = "@Contact",
        dryRun = false// dryRun = true yapıldığında test çalışmaz sadece eksik step definition methodları tespit edilir.

)
public class Runner {}
