package tutorialsNenjatestcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import padges.Searchpage;

import java.io.IOException;

public class searchTest extends Base.base{
    public WebDriver driver;
    Searchpage search;
    @AfterMethod
    public void afterTests(){
        driver.quit();
    }
    @BeforeMethod
    public void Befortest() throws IOException {
        loadpropertiesfile();
        driver= initializemethod(prop.getProperty("browser"));

    }
    @Test(priority = 1)
    public void VerifySearchByValidProduct(){
         search =new Searchpage(driver);
         search.writeinsearch(TestData.getProperty("ValidProduct"));
         search.presssearchicon();

        String ActualproductIsDisplayed=search.searchsuccessforitem();
        String Expectedproductdisplayed =TestData.getProperty("ValidProductMessage");
        Assert.assertEquals(ActualproductIsDisplayed,Expectedproductdisplayed);
        System.out.println("product displayed successfully >> "+ActualproductIsDisplayed);
    }
    @Test(priority = 2)
    public void verifySearchForInValidProduct(){
        search =new Searchpage(driver);
        search.writeinsearch(TestData.getProperty("InValidProduct"));
        search.presssearchicon();

        String Actualmessagefornotexistproduct=search.searchfailfornonexistingitem();
        String expectedmessage= TestData.getProperty("InvalidProductMessage");
        Assert.assertEquals(Actualmessagefornotexistproduct,expectedmessage);
        System.out.println("this item not exist message >>"+Actualmessagefornotexistproduct);
    }
    @Test(priority=3)
    public void veifySearchByNotProvidingAnyProduct(){
        search =new Searchpage(driver);
        search.writeinsearch("");
        search.presssearchicon();

        String Actualmessagefornotexistproduct=search.searchforemptyitem();
        String expectedmessage=TestData.getProperty("InvalidProductMessage");
        Assert.assertEquals(Actualmessagefornotexistproduct,expectedmessage);
        System.out.println("Search with empty item message >>"+Actualmessagefornotexistproduct);

    }
}
