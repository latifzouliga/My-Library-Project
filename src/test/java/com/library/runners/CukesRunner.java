package com.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) // this annotation is coming from cucumber junit
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"},  // define report type
        features = "src/test/resources/features",   //
        glue = "com/library/step_defs",
        tags = "@wip",
        dryRun = false, // generate snippets
        publish = true // generate a public link for reports
)
public class CukesRunner {
}

//FeatureParserException: if you get this exception, you need to fix your feature file
