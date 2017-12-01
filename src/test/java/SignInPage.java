import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

    @FindBy(id="signin-email")
    WebElement emailField;

    @FindBy(css="#signin-password")
    WebElement passField;

    @FindBy(css="#signInSubmit")
    WebElement signInButton;

    @FindBy(css="#js-social__signin > div > form > span:nth-child(8) > div")
    WebElement warningMessage;

    @FindBy(css="#js-social__signup-tab > span")
    WebElement signUpForm;

    @FindBy(css="#js-facebook__signin--button")
    WebElement facebookLink;

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPass(String pass){
        passField.sendKeys(pass);
    }

    public void attemptSignIn(){
        signInButton.click();
    }

    public String getError(){
        return warningMessage.getText();
    }

    public void goToSignUp(){
        signUpForm.click();
    }

    public void launchFacebook(){
        facebookLink.click();
    }
}
