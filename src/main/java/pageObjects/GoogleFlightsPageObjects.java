package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleFlightsPageObjects extends baseClass.Setup {

    //Create constructor and initialize
    public GoogleFlightsPageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"flt-app\"]/div[2]/main[1]/div[4]/div[1]/div[2]/div/div[1]/div[1]/dropdown-menu/div/div[1]/span[1]")
    public WebElement tripOption;

    @FindBy(xpath = "//*[@id=\"flt-app\"]/div[2]/main[1]/div[4]/div[1]/div[2]/div/div[1]/div[1]/dropdown-menu/div/div[2]/menu-item[2]")
    public WebElement oneWay;

    @FindBy(xpath = "//*[@id=\"flt-app\"]/div[2]/main[1]/div[4]/div[1]/div[2]/div/div[2]/div[1]/div[2]")
    public WebElement originTextBox;

    @FindBy(xpath = "//*[@id=\"sb_ifc50\"]/input")
    public WebElement originInputBox;

    @FindBy(xpath = "//*[@id=\"flt-app\"]/div[2]/main[1]/div[4]/div[1]/div[2]/div/div[2]/div[3]/div[2]")
    public WebElement destinationTextBox;

    @FindBy(xpath = "//*[@id=\"sb_ifc50\"]/input")
    public WebElement destinationInputBox;

    @FindBy(xpath = "//*[@id=\"flt-app\"]/div[2]/main[1]/div[4]/div[1]/div[2]/div/div[2]/div[5]/div[1]/div[2]")
    public WebElement departureDateTextBox;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div[4]/div[2]/div[1]/date-input/input")
    public WebElement departureDateInputBox;

//    @FindBy(xpath = "//*[@id=\"flt-app\"]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/div[5]/div[3]/div[2]")
//    public WebElement returnDateTextBox;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div[4]/div[2]/div[3]/date-input/input")
    public WebElement returnDateInputBox;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div[5]/g-raised-button/div/jsl")
    public WebElement doneDateSelector;

    @FindBy(xpath = "//*[@id=\"flt-pax-button\"]")
    public WebElement numberOfPassengers;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div/div[1]/div/div[3]/div[1]")
    public WebElement addAdultPassenger;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div/div[2]/div/div[3]/div[1]")
    public WebElement addChildrenPassenger;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div/div[3]/div/div[3]/div[1]")
    public WebElement addInfantsInSeat;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div/div[4]/div/div[3]/div[1]")
    public WebElement addInfantsOnLap;

    @FindBy(xpath = "//*[@id=\"flt-modaldialog\"]/div/div/div[5]/div[1]")
    public WebElement donePassengerSelector;

}
