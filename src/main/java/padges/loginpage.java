package padges;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormatVisitor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginpage {

    public WebDriver driver;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement writeemail;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement writepassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement cliclonlogin;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement Warningmsgeforinvalidcredentials;





    public loginpage( WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void email(String emailtext) {
        writeemail.sendKeys(emailtext);
    }
    public void password(String password){
        writepassword.sendKeys(password);
    }
    public void clickonlogin(){
        cliclonlogin.click();
    }
    public String msgeofinvalidcredentials(){
        String msge=Warningmsgeforinvalidcredentials.getText();
        return msge;
    }

}





