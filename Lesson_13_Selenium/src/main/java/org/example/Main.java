package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Lesson_13_Selenium/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mts.by");
        // Подтверждаем cookie (если это необходимо, выскакивают не всегда)
        Thread.sleep(2000);
        WebElement cookieAgree = new WebDriverWait(driver, Duration.ofSeconds(5)).until(presenceOfElementLocated(By.id("cookie-agree")));
        if (cookieAgree.isDisplayed()) {
            cookieAgree.click();
        }
        // Ищем поле пополнения на сайте
        driver.findElement(By.className("pay__wrapper"));
        Thread.sleep(2000);
        // 1 пункт Задания
        // Находим заголовок и проверям равенство строк
        WebElement title = driver.findElement(By.cssSelector(".pay__wrapper>h2"));
        String text = title.getText();
        if (text.equals("Онлайн пополнение\nбез комиссии")) {
            System.out.println("First test done");
            System.out.println("значение совпадает с ожидаемым");
        } else {
            System.err.println("Значение не совпадает с ожидаемым");
            System.out.println("Test failed");
            System.out.println(text);
        }

        //2й пункт Задания
        // Задаем массив для 5 лого, и проверям наличие картинок
        WebElement[] logo = new WebElement[5];
        logo[0] = driver.findElement(By.cssSelector(".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']"));
        logo[1] = driver.findElement(By.cssSelector(".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']"));
        logo[2] = driver.findElement(By.cssSelector(".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']"));
        logo[3] = driver.findElement(By.cssSelector(".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']"));
        logo[4] = driver.findElement(By.cssSelector(".pay__partners>ul>li>img[src*='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']"));

        for (int i = 0; i < logo.length; i++) {
            if (logo[i].isDisplayed()) {
                System.out.println("Test for logo done " + i);
            } else {
                System.out.println("Test failed " + i);
            }
        }

        //3й пункт Задания
        // Ищем ссылку и жмякаем
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        if ((driver.findElement(By.linkText("Подробнее о сервисе")).isEnabled())) {
            link.click();
            Thread.sleep(3000);
            if (!(driver.getCurrentUrl().equals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"))) {

                System.out.println("Ошибка: ссылка «Подробнее о сервисе» не работает.");
            }
        }
        driver.navigate().back();


        // 4й - пункт задания
        // Ищем необходимые поля, и заполняем их, жмякаем на кнопку

        WebElement phoneInputField = driver.findElement(By.className("phone"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");
        WebElement sum = driver.findElement(By.className("total_rub"));
        sum.click();
        sum.sendKeys("400");
        WebElement buttonContinue = driver.findElement(By.cssSelector(".button__default"));
        buttonContinue.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(visibilityOfElementLocated(By.cssSelector(".bepaid-app")));
        if (driver.findElement(By.cssSelector(".bepaid-app")).isDisplayed()) {
            System.out.println("Test done: Кнопка 'продолжить' работает корректно");
        } else {
            System.err.println("Test failed: Кнопка не работает должным образом");
        }


    }

}