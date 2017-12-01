import org.apache.bcel.generic.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTraderHomePage {
    //Car ad elements
    @FindBy(css="#js-sell-module > form > input:nth-child(1)")
    WebElement yourCarReg;
    @FindBy(css="#js-sell-module > form > input.c-form__input.no-spinner")
    WebElement yourCarMileage;
    @FindBy(css="#js-sell-module > form > button")
    WebElement createCarAd;

    //Car search elements
    @FindBy(css="#postcode")
    WebElement postcode;
    @FindBy(css="#radius")
    WebElement distance;
    @FindBy(css="#searchVehiclesMake")
    WebElement make;
    @FindBy(css="#searchVehiclesModel")
    WebElement model;
    @FindBy(css="#searchVehiclesPriceFrom")
    WebElement minPrice;
    @FindBy(css="#searchVehiclesPriceTo")
    WebElement maxPrice;

    //Car add methods
    public void enterReg(String reg){
        yourCarReg.sendKeys(reg);
    }
    public void enterMiles(String mil){
        yourCarMileage.sendKeys(mil);
    }
    public void createAd(){
        createCarAd.click();
    }

    //Car search methods
    public void enterPostCode(String zip){
        postcode.sendKeys(zip);
    }
}
