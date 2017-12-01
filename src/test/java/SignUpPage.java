import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {

    @FindBy(css="#email")
    WebElement userEmail;

    @FindBy(css="#password")
    WebElement userPass;

    @FindBy(css="#social--signup--submit")
    WebElement createNewUser;

    @FindBy(xpath="//*[@id=\"js-social__signup\"]/div/form/span[1]/div")
    WebElement emailWarn;

    @FindBy(css="#js-social__signup > div > form > span:nth-child(9) > div")
    WebElement passWarn;

    @FindBy(css="#js-social__signup > div > form > span.social__subtext.social__error-message")
    WebElement passFormatErr;

    public void enterEmail(String email){
        userEmail.sendKeys(email);
    }

    public void enterPass(String pass){
        userPass.sendKeys(pass);
    }

    public void createUser(){
        createNewUser.click();
    }

    public String getEmailErr(){
        return emailWarn.getText();
    }

    public String getPassErr(){
        return passWarn.getText();
    }

    public String getPassFormatErr(){
        return passFormatErr.getText();
    }



}
