import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HomePageTests {

    private String url = "https://www.autotrader.co.uk/";
    private WebDriver webDriver;
    private static ExtentReports report;
    private AutoTraderHomePage home;
    private Actions builder;

    @BeforeClass
    public static void init(){
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir") + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to(url);
        home = PageFactory.initElements(webDriver,AutoTraderHomePage.class);
        builder = new Actions(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }

    @Test
    public void createAdLink(){
        String needCarDetails = "https://selling.autotrader.co.uk/find-car?reg=&mileage=&referrer=ATCOUK";
        String gotReg ="https://selling.autotrader.co.uk/find-car?reg=RF52FJX&mileage=&referrer=ATCOUK";
        String gotMil ="https://selling.autotrader.co.uk/find-car?reg=&mileage=200000&referrer=ATCOUK";
        String completedDetails = "https://selling.autotrader.co.uk/find-car?reg=RF52FJX&mileage=200000&referrer=ATCOUK";
        String reg = "RF52FJX";
        String miles = "200000";
        home.createAd();
        Assert.assertEquals(needCarDetails,webDriver.getCurrentUrl());
        webDriver.navigate().to(url);

        home.enterReg(reg);
        home.createAd();
        Assert.assertEquals(gotReg,webDriver.getCurrentUrl());
        webDriver.navigate().to(url);

        home.yourCarReg.clear();
        home.enterMiles(miles);
        home.createAd();
        Assert.assertEquals(gotMil,webDriver.getCurrentUrl());
        webDriver.navigate().to(url);

        home.enterReg(reg);
        home.enterMiles(miles);
        home.createAd();
        Assert.assertEquals(completedDetails,webDriver.getCurrentUrl());
    }
}
