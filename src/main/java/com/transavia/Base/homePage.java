package com.transavia.Base;

import com.transavia.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

import static com.transavia.Base.TestBase.wait;

public class homePage {
    WebDriver driver;


    public homePage(WebDriver driver1) {

        this.driver = TestBase.getDriver();
    }

    @FindBy(how = How.ID, using = "routeSelection_DepartureStation-input")
     WebElement fromDeparture;

    @FindBy(how = How.ID, using = "routeSelection_ArrivalStation-input")
    WebElement toArrival;

    @FindBy(how = How.ID, using = "booking-passengers-input")
    WebElement numOfPassengers;

    @FindBy(how = How.XPATH, using = "(//button[starts-with(@class,'button button-primary') and @type='submit'])[2]")
    WebElement serchButton;
    @FindBy(how = How.ID, using = "dateSelection_OutboundDate-datepicker")
    WebElement departureon;

    @FindBy(how = How.ID, using = "dateSelection_IsReturnFlight-datepicker")
    WebElement returnOn;

    @FindBy(how = How.XPATH, using = "//*[@id='flights']//div[@data-validation-name='required']/p")
    WebElement fromNToerrorMsg;

    @FindBy(how=How.ID,using="dateSelection_IsReturnFlight")
    WebElement returnOnCheckbox;

    @FindBys(@FindBy( how=How.XPATH,using=".//*[@id='top']//div[@class='HV-gc']//h4"))
    List<WebElement>  flightsCount;

    @FindBy(how=How.XPATH,using="(//div[@id='ui-datepicker-div']//td[not(@class='ui-datepicker-unselectable ui-state-disabled') and @class=\"\"])[1]/a")
    WebElement chooseDepartDate;
    @FindBy(how=How.XPATH,using="(//div[@id='ui-datepicker-div']//td[not(@class='ui-datepicker-unselectable ui-state-disabled') and @class=\"\"])[4]/a")
    WebElement chooseretrntDate;

    @FindBy(how=How.XPATH,using="//input[@id='dateSelection_OutboundDate-datepicker']/following-sibling::span")
    WebElement departCalender;

    @FindBy(how=How.XPATH,using="//input[@id='dateSelection_IsReturnFlight-datepicker']/following-sibling::span")
    WebElement retCalender;






    /**
     * Method for entering the text in inputbox
     */

    public void typeText(WebElement ele, String value) {

        if (!(ele.getAttribute("value").isEmpty())) {
            ele.clear();
        }
        ele.sendKeys(value);
        Reporter.log("Input box is populated with " + value);
    }

    /**
     * Method for clicing on the WebElement
     *
     * @param elt
     */

    public void clickOnWebElement(WebElement elt) {
        elt.click();

    }

    public String getToFieldsErrorMessage(String fromCountry, String errorMessage) throws InterruptedException {
        String errMsg="";
        try {
            fromDeparture.click();
            fromDeparture.sendKeys(fromCountry);
            Reporter.log("Entered the From country name as" + fromCountry);
            wait.until(ExpectedConditions.textToBePresentInElementValue(fromDeparture, fromCountry));

            serchButton.click();
            Reporter.log("Clicked on the saerchButton");

            Thread.sleep(4000);
            errMsg = fromNToerrorMsg.getText();



        } catch (Exception e) {
            Reporter.log(e.getMessage());
        }
        return errMsg;
    }



    public int searchFlightsByDestination(String fromCountry, String toCountry) throws InterruptedException {
        int numberofflights;
        try {
            fromDeparture.click();
            fromDeparture.sendKeys(fromCountry);
            Reporter.log("Entered the From country name as" + fromCountry);
            wait.until(ExpectedConditions.textToBePresentInElementValue(fromDeparture, fromCountry));
            toArrival.click();
            toArrival.sendKeys(toCountry);
            wait.until(ExpectedConditions.textToBePresentInElementValue(toArrival, toCountry));
            Reporter.log("Entered the To country name as" + toCountry);
            serchButton.click();
            Thread.sleep(4000);
            //flightsCount.size();
        } catch (Exception e) {
   Reporter.log(e.getMessage());
        }
        return flightsCount.size();
    }

    public String uncheckReturnOn(){
        String txt="";
       if( returnOnCheckbox.isSelected()){
           returnOnCheckbox.click();
           }
        txt= returnOn.getAttribute("placeholder");
       System.out.println(txt);
return txt;
    }

    public int bookFlight(String fromCountry, String toCountry) throws InterruptedException {
        int numberofflights;
        try {
            fromDeparture.click();
            fromDeparture.sendKeys(fromCountry);
            Reporter.log("Entered the From country name as" + fromCountry);
            wait.until(ExpectedConditions.textToBePresentInElementValue(fromDeparture, fromCountry));
            toArrival.click();
            toArrival.sendKeys(toCountry);
            wait.until(ExpectedConditions.textToBePresentInElementValue(toArrival, toCountry));
            Reporter.log("Entered the To country name as" + toCountry);

            // Choose dates
            departureon.sendKeys(" ");
            departCalender.click();
            Thread.sleep(6000);
            chooseDepartDate.click();
            returnOn.sendKeys(" ");
            retCalender.click();
            chooseretrntDate.click();
            Thread.sleep(6000);
            serchButton.click();
            Thread.sleep(10000);
            //flightsCount.size();
        } catch (Exception e) {
            Assert.fail();
            Reporter.log(e.getMessage());
        }
 return flightsCount.size();
    }
}
