package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HotelsHome;
import pages.HotelsSearchResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static StepDefinitions.SharedSD.getDriver;

public class HotelsSD {


    HotelsHome hotelsHome = new HotelsHome();
HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();
    @Given("^I am on hotels.com home page$")
    public void i_am_on_hotelscom_home_page() throws Throwable {

        Assert.assertEquals(getDriver().getTitle(),
                "Hotels.com India",
                "this is not the darksky home page");

    }

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() throws Throwable {

           hotelsHome.setCityTxt("Mumbai, India");
        hotelsHome.clickSearchButton();
    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars) throws Throwable {
       //5 stars

        hotelsSearchResult.clickStar(stars.split(" ")[0]);
    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) throws Throwable {

        System.out.println(hotelsSearchResult.getStarListText());

        ArrayList<String> starList =hotelsSearchResult.getStarListText();

        String listStarElement = stars.split(" ")[0]+"-star"; // 5 star / 5-star

        int occarance = Collections.frequency(starList,listStarElement);
        int size = starList.size();

        boolean result = occarance==size;

        Assert.assertTrue(result,"all ekements are not :"+listStarElement);


    }
}
