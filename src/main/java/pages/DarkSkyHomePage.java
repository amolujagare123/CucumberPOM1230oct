package pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

public class DarkSkyHomePage extends BasePage{

       By curretTemp = By.xpath("//span[@class='summary swap']");

       By timelineTemp = By.xpath("//span[@class='first']//span");

       By timeListTimeline = By.xpath("//span[@class='hour']/span");

       By expander = By.xpath("//a[@data-day='0']//span[@class='open']");

       By minTempBar = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
       By maxTempBar = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");
       By tempTimelineList = By.xpath("//div[contains(@class,'revealed')]//span[@class='temp']");

       public ArrayList<String> getBarTempList()
       {

              ArrayList<String> list = new ArrayList<>();

              String min =getTextFromElement(minTempBar).split("˚")[0] ; //66˚
              list.add(min);
              String max =getTextFromElement(maxTempBar).split("˚")[0] ; //66˚
              list.add(max);

              return list;
       }

       public ArrayList<String> getTimelineTempList()
       {

              ArrayList<String> list = new ArrayList<>();


              String min = getElementTextList(tempTimelineList).get(0).split("˚")[0] ; //66˚
              list.add(min);
              String max =getElementTextList(tempTimelineList).get(1).split("˚")[0] ; //66˚
              list.add(max);

              return list;
       }



       public void clickExpander()
       {
              JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
              js.executeScript("window.scrollBy(0,800)");
              clickOn(expander);
       }


       public ArrayList<Integer> getTimeList()
       {
              ArrayList<String>  timeList = getElementTextList(timeListTimeline) ;
              System.out.println(timeList);

              ArrayList<Integer> timeListInt = new ArrayList<>();

              for (int i=0;i<timeList.size();i++)
              {
                     String rowTime =  timeList.get(i);
                     int l = rowTime.length();
                     String timeStr = rowTime.substring(0,l-2) ;

                       int time = Integer.parseInt(timeStr);

                       timeListInt.add(time);
              }

              System.out.println(timeListInt);
              return timeListInt;


       }

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
