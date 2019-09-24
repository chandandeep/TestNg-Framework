package common;


import org.openqa.selenium.WebDriver;


/**
 * Created by Chandandeep Singh on 27-02-2019.
 */
public class DriverManagerFactory {

    public static AbstractDriverManager getManager(DriverType type) {
    AbstractDriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new FireFoxDriverManager();

                break;
        }
        return driverManager;


    }

    }
