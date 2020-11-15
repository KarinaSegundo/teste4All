package suport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static final String AUTOMATE_USERNAME = "karinasegundo1";
    public static final String AUTOMATE_ACCESS_KEY = "fszziGGunZPYEYrJWyXn";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

            //public static WebDriver createChrome () {
            // Abrindo o navegador
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Karina\\drives\\chromedriver.exe");
         //   WebDriver navegador = new ChromeDriver();
//

        //    return navegador;
//
     //   }

        public static WebDriver createBrowserStack() {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1920x1080");
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "latest");
            caps.setCapability("os", "Windows");

            WebDriver navegador = null;

            try{
                navegador = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                System.out.println("Problemas na URL: " + e.getMessage());
            }

            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Navegar na página do shopcart
            navegador.get("https://shopcart-challenge.4all.com/");

            return navegador;


        }

    }



