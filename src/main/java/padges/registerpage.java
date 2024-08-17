package padges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerpage {
    public WebDriver driver;
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstname;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastname;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephonenum;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement confirmpassword;
    @FindBy(xpath = "//div//label[@class='radio-inline'][1]")
    WebElement newslettericon;
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement clickoncheckbox;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement clickonsubmit;
    @FindBy(xpath = "//div//h1[text()='Your Account Has Been Created!']")
    WebElement successregestmsge;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningmsgeforsameemailregister;
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    WebElement privacywarningmessage;
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    WebElement firstnamewarningmsge;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    WebElement lastnamewarningmsge;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    WebElement emailwarningmsge;
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    WebElement telephonewarningmsge;
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    WebElement passwordwarningmsge;
    public registerpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void writefirstname(String fstname){
        firstname.sendKeys(fstname);
    }
    public void writelastname(String lstname){
        lastname.sendKeys(lstname);
    }
    public void writeemail(String mail){
        email.sendKeys(mail);
    }
    public void writetelephone(String telephone){
        telephonenum.sendKeys(telephone);
    }
    public void writepassword(String passwordvalue){
        password.sendKeys(passwordvalue);
    }
    public void writeconfirmpassword(String confirmpasswordvalue) {
        confirmpassword.sendKeys(confirmpasswordvalue);
    }
    public void checkboxclick() {
        clickoncheckbox.click();
    }
    public void submitclickon() {
        clickonsubmit.click();
    }

    public void clickonnewslettericon(){
        newslettericon.click();
    }
   public String regestersuccessmsge(){
       String msge=successregestmsge.getText();
       return msge;
   }
   public String msgeforsamemailregister(){
     String msgedisplayed=  warningmsgeforsameemailregister.getText();
     return msgedisplayed;
   }
    public String msgeforprivacywarning(){
        String msgedisplayed=  privacywarningmessage.getText();
        return msgedisplayed;
    }
    public String msgeforfirstnamewarining(){
        String msgedisplayed= firstnamewarningmsge.getText();
        return msgedisplayed;
    }
    public String msgeforlastnamewarining(){
        String msgedisplayed= lastnamewarningmsge.getText();
        return msgedisplayed;
    }
    public String msgeforemailwarining(){
        String msgedisplayed= emailwarningmsge.getText();
        return msgedisplayed;
    }
    public String msgefortelephonewarining(){
        String msgedisplayed= telephonewarningmsge.getText();
        return msgedisplayed;
    }
    public String msgeforpasswordwarining(){
        String msgedisplayed= passwordwarningmsge.getText();
        return msgedisplayed;
    }

}
