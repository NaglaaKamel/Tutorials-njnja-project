package tutorialsNenjatestcases;

import Utilityies.utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import padges.MyAccountpage;
import padges.registerpage;

import java.io.IOException;

public class RegisterTest extends Base.base {
    public WebDriver driver;
    MyAccountpage myaccount;
    registerpage regest;
    @AfterMethod
    public void afterTests(){
        driver.quit();
    }
    @BeforeMethod
    public void Befortest() throws IOException {
        loadpropertiesfile();
        driver = initializemethod(prop.getProperty("browser"));
    }
        @Test
    public void verifyRegisterByMandatoryFields(){
             myaccount = new MyAccountpage(driver);
             myaccount.clickonregister();
             regest= new registerpage(driver);
             regest.writefirstname(TestData.getProperty("firstname"));
             regest.writelastname(TestData.getProperty("lastname"));
             regest.writeemail(utilities.generateEmailWithTimeStamp());
             regest.writetelephone(TestData.getProperty("telephoneNum"));
             regest.writepassword(TestData.getProperty("Password"));
             regest.writeconfirmpassword(TestData.getProperty("ConfirmedPassword"));
            regest.checkboxclick();
            regest.submitclickon();
            String ActualmessageverifyRegistering =regest.regestersuccessmsge();
            System.out.println("Your regertering happen successfully "+"  " + ActualmessageverifyRegistering);
            String Expectedmessage=TestData.getProperty("RegisterByMandatoryFieldsMessage");
            Assert.assertEquals(ActualmessageverifyRegistering,Expectedmessage);
            }
           @Test
            public void VerifyRegisteringByEnteringAllFields(){
               myaccount = new MyAccountpage(driver);
               myaccount.clickonregister();
               regest= new registerpage(driver);
               regest.writefirstname(TestData.getProperty("firstname"));
               regest.writelastname(TestData.getProperty("lastname"));
               regest.writeemail(utilities.generateEmailWithTimeStamp());
               regest.writetelephone(TestData.getProperty("telephoneNum"));
               regest.writepassword(TestData.getProperty("Password"));
               regest.writeconfirmpassword(TestData.getProperty("ConfirmedPassword"));
               regest.clickonnewslettericon();
               regest.checkboxclick();
               regest.submitclickon();
               String ActualmessageverifyRegistering =regest.regestersuccessmsge();
               System.out.println("Your regertering happen successfully "+"  " + ActualmessageverifyRegistering);
               String Expectedmessage=TestData.getProperty("RegisterByMandatoryFieldsMessage");
               Assert.assertEquals(ActualmessageverifyRegistering,Expectedmessage);


            }
            @Test
            public void verifyRegisteringByExestingEmail(){
                myaccount = new MyAccountpage(driver);
                myaccount.clickonregister();
                regest= new registerpage(driver);
                regest.writefirstname(TestData.getProperty("firstname"));
                regest.writelastname(TestData.getProperty("lastname"));
                regest.writeemail(prop.getProperty("email"));
                regest.writetelephone(TestData.getProperty("telephoneNum"));
                regest.writepassword(TestData.getProperty("Password"));
                regest.writeconfirmpassword(TestData.getProperty("ConfirmedPassword"));
                regest.clickonnewslettericon();
                regest.checkboxclick();
                regest.submitclickon();
                String Actualwarningmessage =regest.msgeforsamemailregister();
                String ExpextedWorningMessage=TestData.getProperty("verifyRegisteringByExestingEmailMessage");
                System.out.println("warning message is displayed successfully ::"+"  "+ Actualwarningmessage);
                Assert.assertEquals(Actualwarningmessage,ExpextedWorningMessage);
            }
            @Test
            public  void verifregisteringbyprovidingEmptyFields(){
                myaccount = new MyAccountpage(driver);
                myaccount.clickonregister();
                regest= new registerpage(driver);
                regest.writefirstname("");
                regest.writelastname("");
                regest.writeemail("");
                regest.writetelephone("");
                regest.writepassword("");
                regest.writeconfirmpassword("");
                regest.submitclickon();

                String ActualprivacyWarningmessage=regest.msgeforprivacywarning();
                String ExpextedWorningMessage =TestData.getProperty("PrivacyWarningMessage");
                Assert.assertEquals(ActualprivacyWarningmessage,ExpextedWorningMessage);
                System.out.println("Privacy Warning message >> "+ActualprivacyWarningmessage);

                String ActualFirstNameWarningmessage=regest.msgeforfirstnamewarining();
                String ExpextedFirstNameWorningMessage =TestData.getProperty("FirstnameWarningMessage");
                Assert.assertEquals(ActualFirstNameWarningmessage,ExpextedFirstNameWorningMessage);
                System.out.println("Firstname Warning message >>"+ActualFirstNameWarningmessage);

                 String ActualLastNameWarningmessage=regest.msgeforlastnamewarining();
                String ExpextedLastNameWorningMessage =TestData.getProperty("LastnameWarningMessage");
                Assert.assertEquals(ActualLastNameWarningmessage,ExpextedLastNameWorningMessage);
                System.out.println("Lastname Warning message >>"+ActualLastNameWarningmessage);

                String ActualEmailWarningmessage=regest.msgeforemailwarining();
                String ExpextedEmailWorningMessage =TestData.getProperty("EmailWarningMessage");
                Assert.assertEquals(ActualEmailWarningmessage,ExpextedEmailWorningMessage);
                System.out.println("Email Warning message >> "+ActualEmailWarningmessage);


                String ActualTelephoneWarningmessage=regest.msgefortelephonewarining();
                String ExpextedTelephoneWorningMessage =TestData.getProperty("TelephoneWarningMessage");
                Assert.assertEquals(ActualTelephoneWarningmessage,ExpextedTelephoneWorningMessage);
                System.out.println("Telephone Warning message >>"+ActualTelephoneWarningmessage);


                String ActualPasswordWarningmessage=regest.msgeforpasswordwarining();
                String ExpextedPasswordWorningMessage =TestData.getProperty("PasswordWarningMessage");
                Assert.assertEquals(ActualPasswordWarningmessage,ExpextedPasswordWorningMessage);
                System.out.println("password warning message >>"+ActualPasswordWarningmessage);


            }

        }




