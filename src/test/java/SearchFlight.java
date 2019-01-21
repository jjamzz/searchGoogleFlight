import baseClass.Setup;
import email.SendEmail;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class SearchFlight extends Setup {


    @Test(groups = {"flight"})
    public void testFights() throws InterruptedException {
        Reporter.log("Starting test", true);
        driver.get(prop.getProperty("URL"));
        driver.manage().window().maximize();
        Thread.sleep(1000);

        if (System.getProperty("returnDate").trim().length() > 0) {

            methods.roundTripFlight();

        } else {

            methods.oneWayFlight();

        }

    }


    @AfterTest
    public void tearDown() throws IOException, MessagingException {
        Reporter.log("Starting teardown", true);
        localDate = LocalDate.now();
        fileName = (System.getProperty("origin")) + "-" + (System.getProperty("destination")) + "_" + localDate + ".jpg";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(tmpdir + "/" + fileName));

        // Call the main() method of sendEmail
        String[] arguments = new String[]{""};
        SendEmail.main(arguments);
        driver.quit();
        Reporter.log("teardown done", true);
    }

    @AfterSuite
    public void cleanUp() throws IOException {
        Path path = FileSystems.getDefault().getPath(tmpdir + "/" + fileName);
        Files.deleteIfExists(path);
        Reporter.log("cleanup done", true);
    }

}
