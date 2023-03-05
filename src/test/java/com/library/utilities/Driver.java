package com.library.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;
import java.time.Duration;

public class Driver {


    // Create a private constructor to remove access to this object
    private Driver() {
    }

    /**
     * We make the WebDriver private, because we want to close access from outside the class.
     * We are making it static, because we will use it in a static method.
     * We need to user InheritableThreadLocal class, this class creates multiple threads
     * Which allows us to create multiple driver instances at the same time
     * This will help up do parallel testing with multiple browsers, which will reduce the test execution time
     */
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    static String browser;


    /**
     * This method which will return the same driver instance once we call it.
     * If an instance doesn't exist, it will create first, and then it will always return same instance.
     *
     * @return driverPool.get();
     */
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            if (System.getProperty("browser") == null) {
                // read the browser type from the configuration.properties file.
                // this way, we control which browser is opened from outside our code.
                browser = ConfigurationReader.getProperty("browser");
            } else {
                // reads from mvn command line ,example: mvn test -Dbrowser=remote-chrome
                // for performing tests in remote servers
                browser = System.getProperty("browser");
            }
            System.out.println("Browser: " + browser);


            /**
             * Depending on the browserType returned from the configuration.properties switch statement
             * will determine the "case", and open the matching browser
             */
            switch (browser) {
                case "remote-chrome":
                    try {
                        // assign your grid server address
                        // IP address is stored in configuration properties file
                        String gridAddress = ConfigurationReader.getProperty("grid.server.IP");
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set( new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {
                        // assign your grid server address
                        // IP address is stored in configuration properties file
                        String gridAddress = ConfigurationReader.getProperty("grid.server.IP");
                        URL url = new URL("http://" + gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set( new RemoteWebDriver(url, desiredCapabilities));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    driverPool.set( new ChromeDriver() );
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set( new FirefoxDriver() );
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    driverPool.set( new SafariDriver() );
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                    driverPool.set( new EdgeDriver() );
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }


        return driverPool.get();


    }


    /**
     * closeDriver; it will use quit() method to quit browsers,
     * and then set the driver value back to null to avoid NoSuchSessionException
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            // this line will terminate the driver
            driverPool.get().quit();
            //re-assign the value back to null
            driverPool.remove();
        }
    }

}
