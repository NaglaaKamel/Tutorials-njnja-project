package tutorialsNenjatestcases;

import Utilityies.utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import padges.MyAccountpage;
import padges.registerpage;

import java.io.IOException;

public class registerbydataproviderTest extends Base.base {
    public WebDriver driver;
    MyAccountpage myaccount;
    registerpage regest;

    @AfterMethod
    public void afterTests() {
        driver.quit();
    }

    @BeforeMethod
    public void Befortest() throws IOException {
        loadpropertiesfile();
        driver = initializemethod(prop.getProperty("browser"));
    }

    @Test(priority = 1, dataProvider = "ValidCredentialSupplierforregester")
    public void verifyRegisterByMandatoryFields(String firstname ,String lastname,String telephone,String password,String confirmpass){
        myaccount = new MyAccountpage(driver);
        myaccount.clickonregister();
        regest= new registerpage(driver);
        regest.writefirstname(firstname);
        regest.writelastname(lastname);
        regest.writeemail(utilities.generateEmailWithTimeStamp());
        regest.writetelephone(telephone);
        regest.writepassword(password);
        regest.writeconfirmpassword(confirmpass);
        regest.checkboxclick();
        regest.submitclickon();
        String ActualmessageverifyRegistering =regest.regestersuccessmsge();
        System.out.println("Your regertering happen successfully "+"  " + ActualmessageverifyRegistering);
        String Expectedmessage=TestData.getProperty("RegisterByMandatoryFieldsMessage");
        Assert.assertEquals(ActualmessageverifyRegistering,Expectedmessage);
    }

    @DataProvider(name = "ValidCredentialSupplierforregester")
    public Object[][] supplytestdata() {
        Object[][] data = utilities.getTestDatafromExcell("register");
        return data;
    }
}
