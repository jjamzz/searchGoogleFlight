package baseClass;

import methods.GoogleFlightsMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import pageObjects.GoogleFlightsPageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Properties;

public class Setup {

    public static GoogleFlightsPageObjects pageObjects;
    public static GoogleFlightsMethods methods;
    public static WebDriver driver;
    public static Properties prop;
    public static JavascriptExecutor js;
    public static String fileName;
    public static LocalDate localDate;
    public static Path tmpdir;
    private static String target = "";
    private static String hubUrl = "";


    @BeforeSuite
    public void beforeSuite() throws IOException, InterruptedException {

        Reporter.log("Starting beforeSuite", true);
        prop = new Properties();
        String localDir = System.getProperty("user.dir");
        FileInputStream conf = new FileInputStream(localDir + "/src/main/resources/properties/flightInformation.properties");
        prop.load(conf);
        System.out.println("here");
//        checkHubTarget();
        System.setProperty(prop.getProperty("webdriver"), System.getProperty("env"));
        driver = new ChromeDriver();
        pageObjects = new GoogleFlightsPageObjects(driver);
        methods = new GoogleFlightsMethods(driver);
        js = (JavascriptExecutor) driver;
        tmpdir = Files.createTempDirectory(Paths.get(System.getProperty("user.dir")), "tmp");
        tmpdir.toFile().deleteOnExit();
        Reporter.log("beforeSuite done", true);
    }



//    public void checkHubTarget() throws IOException, InterruptedException {
//
//        target = System.getProperty("target");
//
//        target = target == null ? "default" : target.toLowerCase();
//        switch (target) {
//            case "jenkins":
//                System.out.println("Target: Running on Jenkins");
//                hubUrl = "http://jenkins03:4444/wd/hub";
//                break;
//            case "local":
//                System.out.println("Target: Running on local hub");
//                hubUrl = "http://127.0.0.1:4444/wd/hub";
//                break;
//            default:
//                System.out.println("Starting local grid by default ...");
//
////                String scriptsDirectory = System.getProperty("user.dir") + "/src/main/resources/scripts";
////                String startHub = new String(scriptsDirectory + "/startHub.sh");
//
//                String startHub = "/Users/jsantiago/repositories/searchGoogleFlight/src/main/resources/scripts/startHub.sh";
//
//                Runtime.getRuntime().exec(startHub);
//                System.out.println("Waiting 10 seconds for hub to finish booting ... ");
//                Thread.sleep(10000);
////                String startNode = new String(scriptsDirectory + "/startNode.sh");
////                Runtime.getRuntime().exec(startNode);
//                System.out.println("Waiting 10 seconds for nodes to finish registering ... ");
//                Thread.sleep(10000);
//                hubUrl = "http://127.0.0.1:4444/wd/hub";
//                break;
//        }
//
//    }



}
