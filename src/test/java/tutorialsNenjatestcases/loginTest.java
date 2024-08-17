package tutorialsNenjatestcases;

import Utilityies.utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import padges.MyAccountpage;
import padges.loginpage;

public class loginTest extends Base.base {
    public WebDriver driver;
    MyAccountpage myaccount;
    loginpage login;

    @AfterMethod
            public void afterTests(){
        driver.quit();
    }
    @BeforeMethod
       public void Befortest()  {
        loadpropertiesfile();
       driver= initializemethod(prop.getProperty("browser"));

    }

       @Test(priority = 1,dataProvider = "ValidCredentialSupplier")
       public void verifyLoginWithValidCredentials(String email,String password){
            myaccount = new MyAccountpage(driver);
            login     = new loginpage(driver);
           myaccount.login();
           login.email(email);
           login.password(password);
           login.clickonlogin();
           String accountreturnmsge= myaccount.myaccountmsge();
           System.out.println("actualmsge ="+" "+accountreturnmsge);
           System.out.println("Expectedmsge="+" "+TestData.getProperty("loginSuccessMessage"));
           Assert.assertEquals(accountreturnmsge,TestData.getProperty("loginSuccessMessage"));
       }
//       @DataProvider
//       public Object[][] supplytestdata(){
//          Object [][] data={{"nk1@gmail.com","12345"},{"nk2@gmail.com","12345"},{"nk3@gmail.com","12345"}};
//          return data;
//       }
    @DataProvider(name = "ValidCredentialSupplier")
    public Object[][] supplytestdata(){
        Object[][] data= utilities.getTestDatafromExcell("login");
        return data;
    }
       @Test(priority = 2)
       public void verifyLoginWithInValidCredentials(){
           myaccount = new MyAccountpage(driver);
           login     = new loginpage(driver);
           myaccount.login();
           login.email(utilities.generateEmailWithTimeStamp());
           login.password(prop.getProperty("invalidpassword"));
           login.clickonlogin();String Actualwarningmessage  =login.msgeofinvalidcredentials();
       String ExpextedWorningMessage=TestData.getProperty("InValidCredentialsMessage");
       System.out.println("worning message is displayed successfully ::"+"  "+ Actualwarningmessage);
       Assert.assertTrue(Actualwarningmessage.contains(ExpextedWorningMessage),"Warning message not displayed");

}
@Test(priority=3)
     public void verifyLoginWithInValidEmailAndValidpassword(){
    myaccount = new MyAccountpage(driver);
    login     = new loginpage(driver);
    myaccount.login();
    login.email(utilities.generateEmailWithTimeStamp());
    login.password(prop.getProperty("password"));
    login.clickonlogin();String Actualwarningmessage  =login.msgeofinvalidcredentials();
    String ExpextedWorningMessage=TestData.getProperty("InValidCredentialsMessage");
    System.out.println("worning message is displayed successfully ::"+"  "+ Actualwarningmessage);
    Assert.assertTrue(Actualwarningmessage.contains(ExpextedWorningMessage),"Warning message not displayed");
}
@Test(priority = 4)
    public void verifyLoginWithValidEmailAndInValidpassword(){
    myaccount = new MyAccountpage(driver);
    login     = new loginpage(driver);
    myaccount.login();
    login.email(prop.getProperty("email"));
    login.password(prop.getProperty("invalidpassword"));
    login.clickonlogin();String Actualwarningmessage  =login.msgeofinvalidcredentials();
    String ExpextedWorningMessage=TestData.getProperty("InValidCredentialsMessage");
    System.out.println("worning message is displayed successfully ::"+"  "+ Actualwarningmessage);
    Assert.assertTrue(Actualwarningmessage.contains(ExpextedWorningMessage),"Warning message not displayed");
    }
    @Test(priority = 5)
    public void verifyLoginWithEmptyEmailAndEmptyPassword(){
        myaccount = new MyAccountpage(driver);
        login     = new loginpage(driver);
        myaccount.login();
        login.email("");
        login.password("");
        login.clickonlogin();String Actualwarningmessage  =login.msgeofinvalidcredentials();
        String ExpextedWorningMessage=TestData.getProperty("InValidCredentialsMessage");
        System.out.println("worning message is displayed successfully ::"+"  "+ Actualwarningmessage);
        Assert.assertTrue(Actualwarningmessage.contains(ExpextedWorningMessage),"Warning message not displayed");
    }


}
