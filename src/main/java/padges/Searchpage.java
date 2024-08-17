package padges;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
    public WebDriver driver;
    @FindBy(xpath = "//input[contains(@class,'form-control')]")
    WebElement searchwrite;
    @FindBy(xpath = "//div[@id='search']/descendant::button")
    WebElement Searchicon;
    @FindBy(xpath = "//div[@class='caption']//h4//a")
    WebElement productisdisplayedmsge;
    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
    WebElement productnotexistmsge;
    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
    WebElement searchisemptymsge;


    public Searchpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void writeinsearch(String item){
        searchwrite.sendKeys(item);
    }
    public  void presssearchicon(){
        Searchicon.click();
    }
    public String searchsuccessforitem(){
      String msgesuccess =productisdisplayedmsge.getText();
      return msgesuccess;
    }
    public String searchfailfornonexistingitem(){
        String msgesuccess =productnotexistmsge.getText();
        return msgesuccess;
    }
    public String searchforemptyitem(){
        String msgesuccess =searchisemptymsge.getText();
        return msgesuccess;
    }

}
