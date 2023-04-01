package demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01()throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        
        //With the help of the Action class we can open new empty tabs
        // Actions actions = new Actions(driver);
        // actions.keyDown(Keys.CONTROL).sendKeys(“t”).keyUp(Keys.CONTROL).perform();

        // Launch Chrome :
        // Load URL :https://www.google.com/
        driver.get("https://www.google.com/");

        //Get the current Window handle and store it in the String : driver.getWindowHandle();
        String currentHandle= driver.getWindowHandle();
        System.out.println(currentHandle);

        // Wait for 3 seconds :
        Thread.sleep(2000);

        // Opens a new Tab and switches to new Tab :driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        // Opens Qkart in the newly opened window  :https://crio-qkart-frontend-qa.vercel.app/   / driver.navigate().to();
        driver.navigate().to("https://crio-qkart-frontend-qa.vercel.app/");

        // Wait for 2 seconds :
        Thread.sleep(2000);

        // Opens a new Tab and switches to new Tab :driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        // Opens Qtrip in the newly opened window  :https://qtripdynamic-qa-frontend.vercel.app/   / driver.navigate().to();
        driver.navigate().to("https://qtripdynamic-qa-frontend.vercel.app/");

        // Wait for 2 seconds :
        Thread.sleep(2000);

        // Store all the window handles in String :driver.getWindowHandles();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);

        // Iterate in for each loop and check for window Handles , move back to the first window :for(String actual : handles){}
        for(String actual : handles){
            if(!actual.equalsIgnoreCase(currentHandle)){
                //Switch to the current window
                Thread.sleep(1000);
                // driver.switchTo().window(actual);
                driver.switchTo().window(currentHandle);
            }
        }
        // Print the current window handle
        System.out.println(currentHandle);

    }


}
