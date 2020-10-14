package pages;

import org.openqa.selenium.By;

public class DarkSkyHomePage extends BasePage{

       By curretTemp = By.xpath("//span[@class='summary swap']");

       By timelineTemp = By.xpath("//span[@class='first']//span");

       public String getCurrenttemp()
       {

              String currTempRow =getTextFromElement(curretTemp);// "93˚ Partly Cloudy."

              String expectedTemp = currTempRow.split("˚")[0];

              return expectedTemp;

       }

       public String getTimelineTemp()
       {
              String timelineTempRow = getTextFromElement(timelineTemp);

              String actualTemp = timelineTempRow.split("°")[0];

              return actualTemp;
       }


}
