package pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HotelsHome extends  BasePage{

    By searchButton  = By.xpath("//button[contains(text(),'Search')]");
    By cityTxt = By.xpath("//input[@id='qf-0q-destination']");

    By rooms =By.xpath("//select[@id='qf-0q-rooms']");

    By roomRows = By.xpath("//div[@class='widget-query-people']");

    public int getRoomRows()
    {
        return SharedSD.getDriver().findElements(roomRows).size();
    }

    public void selectRoom(String room)
    {
       selectFromDropdown(rooms,room);
    }

    public  void setCityTxt(String city)
    {

        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].setAttribute('value','"+city+"')",
                SharedSD.getDriver().findElement(cityTxt));

    }





    public void clickSearchButton()
    {
        clickOn(searchButton);
    }


}
