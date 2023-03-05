package com.library.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",              // pointing to directly to rerun.txt
        glue = {"com/library/step_defs", "com/library/failedTestHooks"}

)
public class FailedTestsRunner {
}
