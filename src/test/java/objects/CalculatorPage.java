package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class CalculatorPage {

    WebDriver driver;

    By resultBox = By.id("100");
    By equal = By.name("=");
    By clean = By.name("Clear");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }


    public String calculate(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            driver.findElement(By.name(""+ expression.charAt(i)+"")).click();
        }
        driver.findElement(equal).click();
        return driver.findElement(resultBox).getAttribute("value");
    }


    public void open() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file:///" + file.getAbsolutePath());
    }


    public void clear() {
        driver.findElement(clean).click();
    }
}