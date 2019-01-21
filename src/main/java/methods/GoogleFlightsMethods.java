package methods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class GoogleFlightsMethods extends baseClass.Setup {

    // Constructor
    public GoogleFlightsMethods(WebDriver driver) {
    }


    public static void oneWay() {
        pageObjects.tripOption.click();
        pageObjects.oneWay.click();
    }

    public static void enterOriginLocation() throws InterruptedException {
        pageObjects.originTextBox.click();
        pageObjects.originInputBox.clear();
        Thread.sleep(1000);
        pageObjects.originInputBox.sendKeys(System.getProperty("origin"));
        Thread.sleep(1000);
        pageObjects.originInputBox.sendKeys(Keys.ENTER);
        System.out.println("done");
    }

    public static void enterDestinationLocation() throws InterruptedException {
        pageObjects.destinationTextBox.click();
        pageObjects.destinationInputBox.clear();
        Thread.sleep(1000);
        pageObjects.destinationInputBox.sendKeys(System.getProperty("destination"));
        Thread.sleep(1000);
        pageObjects.destinationInputBox.sendKeys(Keys.ENTER);
    }

    public static void enterDepartureDate() throws InterruptedException {
        pageObjects.departureDateTextBox.click();
        pageObjects.departureDateInputBox.clear();
        Thread.sleep(1000);
        pageObjects.departureDateInputBox.sendKeys(System.getProperty("departureDate"));
        Thread.sleep(1000);
        pageObjects.departureDateInputBox.sendKeys(Keys.ENTER);
    }

    public static void enterReturnDate() throws InterruptedException {
        pageObjects.returnDateInputBox.clear();
        pageObjects.returnDateInputBox.sendKeys(System.getProperty("returnDate"));
        Thread.sleep(1000);
        pageObjects.returnDateInputBox.sendKeys(Keys.ENTER);
    }

    public static void clickDoneDateSelector() {
        pageObjects.doneDateSelector.click();
    }

    public void inputPassengers() throws InterruptedException {
        int numberOfAdults = Integer.parseInt(System.getProperty("numberAdults"));
        int numberOfChildren = Integer.parseInt(System.getProperty("numberChildren"));
        int numberOfInfantsInSeat = Integer.parseInt(System.getProperty("numberInfantsInSeat"));
        int numberOfInfantsOnLap = Integer.parseInt(System.getProperty("numberInfantsOnLap"));

        pageObjects.numberOfPassengers.click();
        Thread.sleep(1500);

        int counter = 1;
        if (numberOfAdults == 1) {
            //do nothing; default is always 1 adult
        } else {
            while (counter < numberOfAdults) {
                pageObjects.addAdultPassenger.click();
                counter++;
            }
        }
        counter = 0;
        while (counter < numberOfChildren) {
            pageObjects.addChildrenPassenger.click();
            counter++;
        }
        counter = 0;
        while (counter < numberOfInfantsInSeat) {
            pageObjects.addInfantsInSeat.click();
            counter++;
        }
        counter = 0;
        while (counter < numberOfInfantsOnLap) {
            pageObjects.addInfantsOnLap.click();
            counter++;
        }
    }

    public static void clickDonePassengerSelector() {
        pageObjects.donePassengerSelector.click();
    }


    public void roundTripFlight() throws InterruptedException {
        Reporter.log("Round trip flight search", true);
        enterOriginLocation();
        Thread.sleep(1500);
        enterDestinationLocation();
        Thread.sleep(1500);
        enterDepartureDate();
        Thread.sleep(1500);
        enterReturnDate();
        Thread.sleep(1500);
        clickDoneDateSelector();
        Thread.sleep(1500);
        inputPassengers();
        Thread.sleep(1500);
        clickDonePassengerSelector();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(5000);
        Reporter.log("Test done", true);
    }

    public void oneWayFlight() throws InterruptedException {
        Reporter.log("One way flight search", true);
        oneWay();
        Thread.sleep(1500);
        enterOriginLocation();
        Thread.sleep(1500);
        enterDestinationLocation();
        Thread.sleep(1500);
        enterDepartureDate();
        Thread.sleep(1500);
        clickDoneDateSelector();
        Thread.sleep(1500);
        inputPassengers();
        Thread.sleep(1500);
        clickDonePassengerSelector();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,200)");
        Thread.sleep(5000);
        Reporter.log("Test done", true);
    }

}
