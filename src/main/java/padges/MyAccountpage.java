package padges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage {
    public WebDriver driver;
    @FindBy(xpath = "//a[@title='My Account']")
    WebElement clickonmyaccount;
    @FindBy(xpath = "//a[text()='Login']")
    WebElement clickonlogin;
    @FindBy(xpath = "//a[text()='Edit your account information']")
    WebElement displaymessageafterlogin;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li[1]//a[1]")
    WebElement clickonregister;

    public MyAccountpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        clickonmyaccount.click();
        clickonlogin.click();

    }
    public void clickonregister(){
        clickonmyaccount.click();
        clickonregister.click();
    }
    public String myaccountmsge(){
      String msge  =displaymessageafterlogin.getText();
        return msge;
    }
}
