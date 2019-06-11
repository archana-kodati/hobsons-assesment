package com.hobson.assesment;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(plugin = { "pretty", "html:target/surefire-reports/cucumber",
        "json:target/surefire-reports/cucumberOriginal.json"},
        features = {"src/test/resources/features"
        },
        tags = {"@feature"},
        glue = {"com.hobson.assesment.steps"})
public class CucumberRunner {

}
