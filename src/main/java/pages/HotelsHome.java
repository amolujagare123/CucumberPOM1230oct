package pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HotelsHome extends  BasePage{

    By searchButton  = By.xpath("//button[contains(text(),'Search')]");
    By cityTxt = By.xpath("//input[@id='qf-0q-destination']");

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
