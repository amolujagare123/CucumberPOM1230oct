package pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResult extends  BasePage{




    By starList = By.xpath("//span[contains(@class,'star-rating-text')]");

    public ArrayList<String> getStarListText()
    {
      return   getElementTextList(starList);
    }


    public void clickStar(String star)
    {
        SharedSD.getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+star+"']")).click();
    }

}
