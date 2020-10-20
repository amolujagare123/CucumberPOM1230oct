package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DarkSkyHomePage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() throws Throwable {

        ArrayList<Integer> timeList = darkSkyHomePage.getTimeList();

        ArrayList<Integer> timeDiffList = new ArrayList<>();

        for(int i=0;i<timeList.size()-1;i++)
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);
            int timeDiff=0;
              if(time2>time1)
               timeDiff = time2-time1;
            if(time2<time1)
                timeDiff = (time2+12)-time1;

            timeDiffList.add(timeDiff);
        }

        System.out.println(timeDiffList);

        int occarance = Collections.frequency(timeDiffList,2);
        int size = timeDiffList.size();
        // if occarance of the oject in the list is equal to the size then it means
        // all the elements are nothe but the object

        boolean result = occarance==size;

        Assert.assertTrue(result,"some differences are not 2");
    }

    @Then("^I verify todays lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly() throws Throwable {

        darkSkyHomePage.clickExpander();

        System.out.println(darkSkyHomePage.getTimelineTempList());
        System.out.println(darkSkyHomePage.getBarTempList());

        ArrayList actual = darkSkyHomePage.getTimelineTempList();
        ArrayList expected =darkSkyHomePage.getBarTempList();

        Assert.assertEquals(actual,expected,"temperatures ore not same");

    }

}
