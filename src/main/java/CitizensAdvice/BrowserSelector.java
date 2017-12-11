package CitizensAdvice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrowserSelector extends BasePage {


    LoadProp loadProp = new LoadProp();

    //This will run from System
    String browser =loadProp.getProperty("browser");

    //This will run from Jenkins
//    String browser = System.getProperty("browser");

    public void selectBrowser(){

        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();

        }else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src\\test\\Resources\\BrowserDriver\\chromedriver.exe");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("password_manager_enabled", false);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");

            DesiredCapabilities caps = DesiredCapabilities.chrome();
            caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            caps.setCapability("chrome.switches", Arrays.asList("--incognito"));
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(caps);

        }else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();

        }else {
            System.out.println("Browser name is wrong");
        }
    }
}
