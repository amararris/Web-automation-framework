package us.piit;


import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.InterruptedIOException;
import java.util.List;

public class AppTest extends CommonAPI {
    @Test
    public void radioButton() throws InterruptedException {
        List<WebElement> radioButtonClick=driver.findElements(By.xpath("//input[@name='radioButton']"));
        for (WebElement element:radioButtonClick){
            if (!element.isSelected());
            element.click();
        }
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//legend[text()='Radio Button Example']")).click();

    }
    @Test
    public void suggestion() throws  InterruptedException {
        suggestion("//input[@id='autocomplete']", "can", "Central African Republic", "//ul[@id='ui-id-1']/li");
        Thread.sleep(2000);
    }
    @Test
    public void dropDownOption() throws InterruptedException{
      selectFromDropdown("//select[@id='dropdown-class-example']", "Option1");
      Thread.sleep(2000);
        selectFromDropdown("//select[@id='dropdown-class-example']", "Option2");
        Thread.sleep(2000);
        selectFromDropdown("//select[@id='dropdown-class-example']", "Option3");
        Thread.sleep(2000);
    }
    @Test
    public void checkBox() throws InterruptedException{
        List<WebElement> listOfElements = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement element: listOfElements) {
            element.click();
        }
        Thread.sleep(2000);
        WebElement Option2= driver.findElement(By.xpath("//input[@id='checkBoxOption2']"));
        boolean isSelected=Option2.isDisplayed();
        if (isSelected){
            Option2.click();
        }
        if (!isSelected){
            Option2.isDisplayed();
        }
        Thread.sleep(2000);
    }
    @Test
    public void switchWindow() throws InterruptedException{
        click("//button[@id='openwindow']");
        tabHandle();
        click("//a[text()='Home']");
        Thread.sleep(2000);
    }
    @Test
    public void alerts() throws InterruptedException{
        type("//input[@id='name']", "amar");
        Thread.sleep(2000);
        click("//input[@id='alertbtn']");
        alertAccept();
        Thread.sleep(2000);
    }
   // @Test
    public void confirm() throws InterruptedException {
        type("//input[@id='name']", "amar");
        Thread.sleep(2000);
        click("//input[@id='confirmbtn']");
        alertDismiss();
        Thread.sleep(2000);
    }
    @Test
    public void elementDisplay() throws InterruptedException{
        JavascriptExecutor js =(JavascriptExecutor) driver;
        WebElement display = driver.findElement(By.xpath("//legend[text()='Element Displayed Example']"));
        js.executeScript("arguments[0].scrollIntoView", display);
        Thread.sleep(2000);
        type("//input[@id='displayed-text']", "amar");
        Thread.sleep(2000);
        click("//input[@id='hide-textbox']");
        Thread.sleep(2000);
        click("//input[@id='show-textbox']");
        Thread.sleep(2000);

    }
    @Test
    public void mousehover() throws InterruptedException {
        scrollDown();
        hoverOver("//button[@id=\"mousehover\"]");
        Thread.sleep(2000);
        click("//a[text()=\"Top\"]");
        Thread.sleep(3000);
    }

    @Test
    public void reload() throws InterruptedException {
        scrollDown();
        Thread.sleep(2000);
        hoverOver("//button[@id=\"mousehover\"]");
        Thread.sleep(2000);
        click("//a[text()=\"Reload\"]");
        Thread.sleep(2000);

    }
    @Test
    public void webTable(){
        System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(2) td:nth-child(1)")).getText());
        System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(7) td:nth-child(2)")).getText());
        System.out.println(driver.findElement(By.cssSelector("table[name='courses'] tr:nth-child(11) td:nth-child(3)")).getText());
    }
    @Test
    public void tableHeader() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)  driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.cssSelector(".tableFixHead table")));
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.cssSelector(".tableFixHead table tbody tr:nth-child(9)")));
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//div[contains(text(),'Total Amount Collected: 296')]")).getText();
        String newText = text.replaceAll("[^0-9]", "");
        Assert.assertEquals(Integer.parseInt(newText), 296);
        System.out.println(newText);
        Thread.sleep(2000);

    }
    @Test
    public void switchiFrame() throws InterruptedException {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.cssSelector("#mousehover")));
        Thread.sleep(2000);
        driver.switchTo().frame("iframe-name");
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        Thread.sleep(2000);
    }

}
