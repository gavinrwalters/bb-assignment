package com.walters.bb;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 *  * @author gavin.walters
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features"}, 
				 glue = {"com.walters.bb" },
				 // Overridden tags at environment level
				 //tags = "@english",
				 strict = true,
				 plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"})
public class RunBBTest {
}