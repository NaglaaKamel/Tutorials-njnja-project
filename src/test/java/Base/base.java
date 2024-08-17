package Base;

import Utilityies.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class base {

       public WebDriver driver;

        public Properties prop;
         public Properties TestData;

        public void loadpropertiesfile()   {
            prop = new Properties();

            File probfile = new File(System.getProperty("user.dir")+"\\src\\main\\TutorialsConfiguration\\config.properties");
            try {
                FileInputStream fis = new FileInputStream(probfile);
                prop.load(fis);
            }catch(Throwable e){
                e.printStackTrace();
            }
             TestData= new Properties();
            File Testdatafile = new File(System.getProperty("user.dir")+"\\src\\main\\TutorialsConfiguration\\testdata.properties");
            try{
                FileInputStream TSD = new FileInputStream(Testdatafile);
                TestData.load(TSD);
            }catch(Throwable e){
                e.printStackTrace();

            }
        }
        public   WebDriver initializemethod(String browser){
            if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }else if(browser.equalsIgnoreCase("edge")){
                driver = new EdgeDriver();
            }else if(browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.Implicit_Wait_Time));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.Page_Wait_Time));
            driver.get(prop.getProperty("url"));

         return driver;


        }


}

