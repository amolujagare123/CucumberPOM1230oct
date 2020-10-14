package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DarkSkyHomePage;

import static StepDefinitions.SharedSD.getDriver;

public class darkskyHomeSD {

       DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();


    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {

        Assert.assertEquals(getDriver().getTitle(),
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                "this is not the darksky home page");

    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {

        String expected = darkSkyHomePage.getCurrenttemp();
        System.out.println("Expected="+expected);
        String actual = darkSkyHomePage.getTimelineTemp();
        System.out.println("Actual="+actual);
        Assert.assertEquals(actual,expected,"both tempratures are not equal");
    }
}
