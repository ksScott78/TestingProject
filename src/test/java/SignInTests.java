import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class SignInTests {

        private String url = "https://www.autotrader.co.uk/secure/signin?after-sigin-url=/";
        private WebDriver webDriver;
        private static ExtentReports report;
        private SignInPage signIn;
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
            signIn = PageFactory.initElements(webDriver,SignInPage.class);
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
        public void signInAttempt(){
            String attemptEmail = "abcd@gmail.com";
            String attemptPass = "password";

            String warn1 = "Your email or password was incorrect. Please try again.";

            signIn.attemptSignIn();
            Assert.assertEquals(warn1,signIn.getError());

            signIn.enterEmail(attemptEmail);
            Assert.assertEquals(warn1,signIn.getError());

            signIn.emailField.clear();
            signIn.enterEmail(attemptEmail);
            signIn.enterPass(attemptPass);

            Assert.assertEquals(warn1,signIn.getError());
        }

        @Test
        public void createAccount() throws InterruptedException{
            String emailWarn = "Please enter your email address";
            String passWarn = "Please enter your email password";

            signIn.goToSignUp();



        }
}
