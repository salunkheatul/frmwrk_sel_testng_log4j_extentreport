package utilities;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Log4j {

    private static WebDriver driver = null;


    public static void main(String[] args){

        Log4j log4j=new Log4j();

        Logger log=Logger.getLogger(log4j.getClass());

        String log4JPropertyFile = "/Users/atul/IdeaProjects/platform/src/test/resources/log4j.properties";
        Properties p = new Properties();

        try {
            p.load(new FileInputStream(log4JPropertyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PropertyConfigurator.configure(p);

// Create a new instance of the chrome driver
        driver = Init.getChromeDriver();

// Hit the URL for which you want to see logs
        driver.get("https://www.google.co.in");

        //BasicConfigurator.configure();     //for console based basic printing

// Create reference variable “log” referencing getLogger method of Logger class, it is used to store logs in selenium.txt

// Call debug method with the help of referencing variable log and log the information in test.logs file
       log.debug("Getting errors");

       log.info("getting info");

       log.debug("Getting errors");

       log.info("getting info");

        driver.close();

    }

}
