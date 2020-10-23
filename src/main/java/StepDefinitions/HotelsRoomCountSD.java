package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HotelsHome;

public class HotelsRoomCountSD {

    HotelsHome hotelsHome = new HotelsHome();

    @When("^I select (.+) from room dropdown$")
    public void i_select_from_room_dropdown(String selectrooms)  {

         hotelsHome.selectRoom(selectrooms);
    }

    @Then("^I verify (.+) is displayed$")
    public void i_verify_is_displayed(String numberofroomdropdown) {

        int expectedRoomcount = Integer.parseInt(numberofroomdropdown);
        int actualRoomcount = hotelsHome.getRoomRows();

        System.out.println("Expected="+expectedRoomcount);
        System.out.println("Actual="+actualRoomcount);

        Assert.assertEquals(actualRoomcount,expectedRoomcount,"room count is different");


    }

}
