package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HotelsHome;
import pages.HotelsSearchResult;

import java.util.ArrayList;
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

    @Then("^I verify system displays all hotels within \"([^\"]*)\" Km radius of airport$")
    public void i_verify_system_displays_all_hotels_within_something_km_radius_of_airport(String expectedDistanceStr) throws Throwable {

        ArrayList<Double> distList =hotelsSearchResult.getDistlist();
        System.out.println(distList);

        Double expectedDistance = Double.parseDouble(expectedDistanceStr);

        boolean flag = true;
        ArrayList<Double> greterDistList = new ArrayList<>();

        for (int i=0;i<distList.size();i++)
        {
           if(distList.get(i)> expectedDistance)
           {
               flag = false;
               greterDistList.add(distList.get(i));
           }
        }

        Assert.assertTrue(flag,"some distances are greater than:"+expectedDistance+
                " Thse are:"+greterDistList);


    }

    @And("^I verify \"([^\"]*)\" is within radius$")
    public void i_verify_something_is_within_radius(String hotelname) {

        ArrayList<String> hotelList = hotelsSearchResult.getHotelList();

        boolean flag = false;

        for(int i=0;i<hotelList.size();i++)
        {
            if(hotelList.get(i).contains(hotelname))
            {
                flag = true;
                break;
            }
        }

        Assert.assertTrue(flag,"This hotel is not in the range");
    }

    @Then("^I verify todays deal is less than \"([^\"]*)\" rs$")
    public void i_verify_todays_deal_is_less_than_something_rs(String expectedDealPriceStr) throws Throwable {


        hotelsSearchResult.clickStar("4");

        int expectedDealPrice = Integer.parseInt(expectedDealPriceStr);
        int actualdealPrice = hotelsSearchResult.getDealPrice();

        System.out.println(hotelsSearchResult.getDealPrice());

        boolean result = actualdealPrice <expectedDealPrice;

        Assert.assertTrue(result,"the actual deal price is greater than:"+expectedDealPrice);


    }

}
