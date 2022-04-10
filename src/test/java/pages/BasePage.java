package pages;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.ini4j.Ini;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }


    public static void mouseHover(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public static void click(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.click(element).build().perform();
    }

    public static void rightClick(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.contextClick(element).build().perform();
    }

    public static void dragNDrop(WebDriver driver, WebElement element1,WebElement element2){
        Actions act = new Actions(driver);
        act.dragAndDrop(element1,element2).build().perform();
    }


    public static void acceptAlert(WebDriver driver){
        Alert alert =  driver.switchTo().alert();
        System.out.println("Title of alert: "+alert.getText());
        alert.accept();
    }


    public static void dismissAlert(WebDriver driver){
        Alert alert =  driver.switchTo().alert();
        System.out.println("Title of alert: "+alert.getText());
        alert.dismiss();
    }

    public static void acceptAlert(WebDriver driver,String text){
        Alert alert =  driver.switchTo().alert();
        System.out.println("Title of alert: "+alert.getText());
        alert.sendKeys(text);
        alert.accept();
    }

    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static void elementHighlight(WebDriver driver, WebElement element, String colour){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",element);
    }


    public static void selectByVisibletext(WebElement element,String text){
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public static void selectByValue(WebElement element,String text){
        Select sel = new Select(element);
        sel.selectByValue(text);
    }

    public static void selectByIndex(WebElement element,int index){
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }



    public static void deselectByVisibletext(WebElement element,String text){
        Select sel = new Select(element);
        sel.deselectByVisibleText(text);
    }

    public static void deselectByValue(WebElement element,String text){
        Select sel = new Select(element);
        sel.deselectByValue(text);
    }

    public static void deselectByIndex(WebElement element,int index){
        Select sel = new Select(element);
        sel.deselectByIndex(index);
    }

    public static void deselectAll(WebElement element){
        Select sel = new Select(element);
        sel.deselectAll();
    }

    public static void takeScreenshot(WebDriver driver){
        try {
            TakesScreenshot srcShot = (TakesScreenshot) driver;
            File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("./screenshot.png");
            FileUtils.copyFile(srcFile, destFile);
        }catch (Exception e){

        }

    }


    public static void assertTitle(WebElement element,String text){
        String value = element.getText();
        Assert.assertEquals(value,text,"Title mismatch");
    }


    public static String getFirstName(){
        Faker faker = new Faker(new Locale("en-IND"));
       String fn =  faker.name().firstName();
       return fn;
    }


    public static String getLastName(){
        Faker faker = new Faker(new Locale("en-IND"));
        String ln =  faker.name().lastName();
        return ln;
    }


    public static String getEmail(){
        Faker faker = new Faker(new Locale("en-IND"));
        String email =  faker.name().fullName()
                .trim().replace(" ","").replace(".","")+"@testmail.com";
        return email;
    }


    public static String getMobileNumber(){
        Faker faker = new Faker(new Locale("en-IND"));
        String num =  faker.number().digits(10);
        return num;
    }


    public static String getValue(String header, String key) {
        String path = System.getProperty("user.dir") +
                File.separator + "Data" + File.separator + "data.ini";
        String val = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Ini ini = new Ini();
            ini.load(fis);
            val = ini.get(header, key);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;

    }

    public static String getValue(String key){

        String path = System.getProperty("user.dir")+ File.separator+"config.properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
              value = prop.getProperty(key);
        }catch (Exception e){

        }
        return value;
    }
}
