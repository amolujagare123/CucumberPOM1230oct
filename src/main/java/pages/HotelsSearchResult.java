package pages;

import StepDefinitions.SharedSD;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HotelsSearchResult extends  BasePage{




    By starList = By.xpath("//span[contains(@class,'star-rating-text')]");

    By distTextAirport = By.xpath("//ul[@class='property-landmarks']//li[2]");

    By hoteltextList = By.xpath("//a[@class='property-name-link']");

    By dealPrice = By.xpath("//li[contains(@class,'deal-of-the-day')]//ins");

    public int getDealPrice()
    {
        String priceRow = getTextFromElement(dealPrice);

        String priceTxtWithoutRs

                = priceRow.substring(2); // 3,870

        String priceStr="";

        for(int i=0;i<priceTxtWithoutRs.length();i++)
        {

            if(priceTxtWithoutRs.charAt(i)!=',')
                priceStr = priceStr + priceTxtWithoutRs.charAt(i);
        }


        int price = Integer.parseInt(priceStr);

        return  price;
    }




    public ArrayList<String> getHotelList()
    {
        return  getElementTextList(hoteltextList);
    }

    public ArrayList<Double> getDistlist()
    {
        ArrayList<String> textList =getElementTextList(distTextAirport);
        ArrayList<Double> distList = new ArrayList<>();


        for(int i=0;i<textList.size();i++)
        {
            String distanceStr = textList.get(i).split(" ")[0]; // number in text format

            Double distance = Double.parseDouble(distanceStr);

            distList.add(distance);

        }

        return  distList;
    }


    public ArrayList<String> getStarListText()
    {
      return   getElementTextList(starList);
    }


    public void clickStar(String star)
    {
        SharedSD.getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+star+"']")).click();
    }

}
