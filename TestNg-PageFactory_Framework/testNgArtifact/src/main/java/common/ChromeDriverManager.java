package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by Chandandeep Singh on 27-02-2019.
 */
public class ChromeDriverManager extends AbstractDriverManager {

    private ChromeDriverService chromeDriverService;

    @Override
    protected void startService() {
    if(null==chromeDriverService){
     try{
         chromeDriverService = new ChromeDriverService.Builder().usingDriverExecutable(new File("E:\\TestNg-PageFactory_Framework\\testNgArtifact\\drivers\\chrome_3.exe"))
                 .usingAnyFreePort()
                 .build();
         chromeDriverService.start();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
    }

    @Override
    protected void stopService() {
        if (null != chromeDriverService && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }

    @Override
    protected void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(chromeDriverService, capabilities);
    }
}
