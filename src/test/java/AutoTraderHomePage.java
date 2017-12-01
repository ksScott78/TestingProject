import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTraderHomePage {

    @FindBy(css="#js-sell-module > form > input:nth-child(1)")
    WebElement yourCarReg;

    @FindBy(css="#js-sell-module > form > input.c-form__input.no-spinner")
    WebElement yourCarMileage;

    @FindBy(css="#js-sell-module > form > button")
    WebElement createCarAd;


    public void enterReg(String reg){
        yourCarReg.sendKeys(reg);
    }

    public void enterMiles(String mil){
        yourCarMileage.sendKeys(mil);
    }

    public void createAd(){
        createCarAd.click();
    }
}
