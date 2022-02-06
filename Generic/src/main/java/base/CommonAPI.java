package base;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amar\\IdeaProjects\\web-automation-framework\\Generic\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice//");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    public void click(String locator){
        try {
            driver.findElement(By.xpath(locator)).click();
        }catch (Exception e){
            driver.findElement(By.cssSelector(locator)).click();
        }
    }
    public void type(String locator, String text){
        try {
            driver.findElement(By.xpath(locator)).sendKeys(text);
        }catch (Exception e){
            driver.findElement(By.cssSelector(locator)).sendKeys(text);
        }
    }

       public void suggestion (String suggestionLocator, String textToEnter, String textLookingFor, String listOfSuggestion){
           driver.findElement(By.xpath(suggestionLocator)).sendKeys(textToEnter);
           List<WebElement> listOfElements=driver.findElements(By.xpath(listOfSuggestion));
           for (WebElement element:listOfElements){
               if (element.getText().equals(textLookingFor)){
                   element.click();
               }
           }

       }
    public void tabHandle(){
        String parentWindowHandle = driver.getWindowHandle();
        for (String chidTab: driver.getWindowHandles()){
            driver.switchTo().window(chidTab);
        }
        System.out.println(driver.getTitle());
    }
    public void selectFromDropdown(String dropdownLocator, String option) {
        WebElement element = driver.findElement(By.xpath(dropdownLocator));
        Select select = new Select(element);
        try {
            select.selectByVisibleText(option);
        } catch (Exception e) {
            select.deselectByVisibleText(option);
        }
    }
    public void alertAccept(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void alertDismiss(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor)  driver;
        js.executeScript("arguments[0].scrollIntoView(true)");
    }

    public void hoverOver(String locater) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(locater));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

    }
   }






