package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

/*
 ----------------Activity1---------------
 @CucumberOptions(
    features = "Features",
    glue = {"stepDefenitions"},
    tags = "@activity1_1"
    )
  ----------------Activity2---------------
  @CucumberOptions(
    features = "Features",
    glue = {"stepDefenitions"},
    tags = "@activity1_2"
) 
 ----------------Activity3---------------
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefenitions"},
	    tags = "@activity1_3"
	)
 ----------------Activity4---------------
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefenitions"},
	    tags = "@activity2_4"
	)
 ----------------Activity5---------------
	@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefenitions"},
	    tags = "@activity2_5"
	)
 ----------------Activity6---------------
	@CucumberOptions(
    features = "Features",
    glue = {"stepDefenitions"},
    tags = "@SimpleAlert",
    plugin = {"pretty"},
    monochrome = true
)
 ----------------Activity6---------------
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefenitions"},
	    tags = "@SimpleAlert",
	    plugin = {"html: test-reports"},
	    monochrome = true
	)
	
	
*/
//------------Activity6-----------
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefenitions"},
	    tags = "@SimpleAlert",
	    plugin = {"json: test-reports/json-report.json"},
	    monochrome = true
	)

public class ActivitiesRunner {
    //empty
}