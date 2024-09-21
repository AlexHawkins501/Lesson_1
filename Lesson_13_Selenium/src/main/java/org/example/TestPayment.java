package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestPayment {

    private WebDriver driver;

    public TestPayment(WebDriver driver) {
        this.driver = driver;
    }

    // Задаем для параметра "Услуги свзяи"
    private final By payWindow = By.className("pay__wrapper");
    private final By phoneNumberField = By.id("connection-phone");
    private final By phoneSumField = By.id("connection-sum");
    // Задаем для параметра "Домашний интернет"
    private final By internetSumField = By.id("internet-sum");
    private final By internetPhoneField = By.id("internet-phone");
    // Задаем для параметра "Рассрочка"
    private final By scoreField = By.id("score-instalment");
    private final By installmentSumField = By.id("instalment-sum");
    // Задаем для параметра "Задолженность"
    private final By arrearsScoreField = By.id("score-arrears");
    private final By arrearsSumField = By.id("arrears-sum");

    private final By continueButton = By.cssSelector(".button__default");
    private final By cookiesAgree = By.id("cookie-agree");
    private final By selectHeader = By.className("select__header");
    private final By internetForm = By.xpath("//*[@class='select__option'][contains(text(),'Домашний интернет')]");
    private final By installmentForm = By.xpath("//*[@class='select__option'][contains(text(),'Рассрочка')]");
    private final By arrearsForm = By.xpath("//*[@class='select__option'][contains(text(),'Задолженность')]");
    private final By connectionForm = By.xpath("//*[@class='select__option'][contains(text(),'Услуги связи')]");

    public void setCookiesAgree() {
        while (true) {
            try {
                WebElement cookies = driver.findElement(cookiesAgree);
                if (cookies.isDisplayed()) {
                    cookies.click();
                    return;
                } else {
                    driver.navigate().refresh();
                    Thread.sleep(3000);
                }
            } catch (NoSuchElementException | InterruptedException e) {

            }
        }
    }

    public void checkEmptyFieldLabels() {
        checkSelectedOption();
        checkVisibleFields();
    }

    private void checkSelectedOption() {
        try {
            WebElement selectedOption = new WebDriverWait(driver, Duration.ofSeconds(10)).until(presenceOfElementLocated(By.cssSelector(".pay_form .select__now")));
            System.out.println("Выбранная опция: " + selectedOption.getText());
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Не удалось определить выбранную опцию");
        }
    }

    private void checkVisibleFields() {
        checkFieldIfVisible(phoneNumberField, "Номер телефона (Услуги связи)");
        checkFieldIfVisible(phoneSumField, "Сумма (Услуги связи");

        checkFieldIfVisible(internetPhoneField, "Номер телефона (интернет)");
        checkFieldIfVisible(internetSumField, "Сумма (интернет)");

        checkFieldIfVisible(scoreField, "Номер счета (рассрочка)");
        checkFieldIfVisible(installmentSumField, "Cумма (Рассрочка)");

        checkFieldIfVisible(arrearsScoreField, "Номер счета (задолженность)");
        checkFieldIfVisible(arrearsSumField, "Сумма (Задолженность)");
    }

    private void checkFieldIfVisible(By locator, String fieldName) {
        try {
            WebElement field = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));

            String placeholderText = field.getAttribute("placeholder");
            String fieldValue = field.getAttribute("value");

            System.out.println(fieldName + ":");
            System.out.println("  Placeholder: " + placeholderText);
            if (fieldValue.isEmpty()) {
                System.out.println("  Поле не заполнено");
            } else {
                System.out.println("  Значение поля: " + fieldValue);
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println(fieldName + ": поле не найдено или не видимо");
        }
        System.out.println();
    }

    public void findPayWindow() {
        driver.findElement(payWindow);
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
    }

    public void checkLogoPaymentSys() {
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
                return;
            }
        }
    }


    public void changeHeaderPaymentHomeInternet() {
        driver.findElement(selectHeader).click();
        driver.findElement(internetForm).click();
        checkFieldIfVisible(internetPhoneField, "Номер телефона (Интернет)");
        checkFieldIfVisible(internetSumField, "Сумма (Интернет)");
    }

    public void changeHeaderPaymentInstallmentPlan() {
        driver.findElement(selectHeader).click();
        driver.findElement(installmentForm).click();
        checkFieldIfVisible(scoreField, "Номер счета (Рассрочка)");
        checkFieldIfVisible(installmentSumField, "Сумма (Рассрочка)");
    }

    public void changeHeaderPaymentArrears() {
        driver.findElement(selectHeader).click();
        driver.findElement(arrearsForm).click();
        checkFieldIfVisible(arrearsScoreField, "Номер счета (Задолженность)");
        checkFieldIfVisible(arrearsSumField, "Сумма (Задолженность)");
    }

    public void changeHeaderPaymentPhone() {
        driver.findElement(selectHeader).click();
        driver.findElement(connectionForm).click();
        checkFieldIfVisible(phoneNumberField, "Номер телефона (Услуги связи)");
        checkFieldIfVisible(phoneSumField, "Сумма (Услуги связи)");
    }

    public void paymentPhoneNumber() throws InterruptedException {
        String phoneNumber = "297777777";
        String amount = "80";

        driver.findElement(selectHeader).click();
        driver.findElement(connectionForm).click();
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(phoneSumField).sendKeys(amount);

        driver.findElement(continueButton).click();
        Thread.sleep(3000);
        // Обращаемся к всплывающему окну
        WebElement iframe = driver.findElement(By.cssSelector("iframe.bepaid-iframe"));
        driver.switchTo().frame(iframe);
        Thread.sleep(3000);

        // Проверяем сумму в новом окне
        WebElement paymentAmount = driver.findElement(By.cssSelector(".pay-description__cost"));
        String amountText = paymentAmount.getText();
        if (amountText.contains(amount + ".00 BYN")) {
            System.out.println("Сумма в окне оплаты отображается корректно: " + amountText);
        } else {
            System.err.println("Ошибка: сумма в окне оплаты отображается некорректно: " + amountText);
        }

        // Проверяем номер телефона
        WebElement phoneNumberDisplay = waitForElement(By.cssSelector(".pay-description__text"), 10);
        String phoneNumberText = phoneNumberDisplay.getText();
        if (phoneNumberText.contains("375" + phoneNumber)) {
            System.out.println("Номер телефона отображается корректно: " + phoneNumberText);
        } else {
            System.err.println("Ошибка: номер телефона отображается некорректно: " + phoneNumberText);
        }


        // Проверяем наличие кнопки оплаты и ее текст
        WebElement payButton = waitForElement(By.xpath("//button[@type='submit'][contains(text(), 'Оплатить')]"), 10);
        if (payButton.isDisplayed() && payButton.getText().contains(amount + ".00 BYN")) {
            System.out.println("Кнопка оплаты отображается корректно");
        } else {
            System.err.println("Ошибка: кнопка оплаты отображается некорректно");
        }

        // Проверяем наличие иконок платежных систем и проверяем все поля
        checkPaymentSystemIcons();
        checkPaymentFormFields();
    }

    public void checkPaymentFormFields() {
        // Определяем локаторы для нужных полей
        By[] fieldLocators = {
                By.xpath("//input[contains(@class, 'ng-tns-c46-1') and @formcontrolname='creditCard']"),
                By.xpath("//input[contains(@class, 'ng-tns-c46-5') and @formcontrolname='cvc']"),
                By.xpath("//input[contains(@class, 'ng-tns-c46-4') and @formcontrolname='expirationDate']"),
                By.xpath("//input[contains(@class, 'ng-tns-c46-3') and @formcontrolname='holder']")
        };

        String[] fieldNames = {"Номер карты", "CVC", "Срок действия", "Имя держателя"};

        for (int i = 0; i < fieldLocators.length; i++) {
            checkFieldAndLabel(fieldLocators[i], fieldNames[i]);
        }

        // Возвращаемся к основному контексту страницы
        driver.switchTo().defaultContent();
    }

    private void checkFieldAndLabel(By fieldLocator, String expectedLabelText) {
        try {
            WebElement field = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(fieldLocator));

            // Находим label для поля
            WebElement label = driver.findElement(By.xpath("//label[contains(@class, 'ng-star-inserted') and contains(text(), '" + expectedLabelText + "')]"));

            String labelText = label.getText();
            String fieldValue = field.getAttribute("value");
            String placeholder = field.getAttribute("placeholder");

            System.out.println("Поле: " + expectedLabelText);
            System.out.println("  Текст метки (label): " + labelText);
            System.out.println("  Placeholder: " + (placeholder != null ? placeholder : "отсутствует"));
            if (fieldValue.isEmpty()) {
                System.out.println("  Статус: не заполнено");
            } else {
                System.out.println("  Статус: заполнено");
                System.out.println("  Значение: " + fieldValue);
            }
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Поле не найдено или не видимо: " + expectedLabelText);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Label не найден для поля: " + expectedLabelText);
        }
        System.out.println();
    }

    private WebElement waitForElement(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private void checkPaymentSystemIcons() {
        String[] paymentSystems = {"visa", "mastercard", "belkart", "mir", "maestro"};
        By iconLocator = By.cssSelector("div.icons-container.ng-tns-c46-1 img");
        List<WebElement> icons = driver.findElements(iconLocator);

        if (icons.size() == paymentSystems.length) {
            System.out.println("Все иконки платежных систем присутствуют");
        } else {
            System.err.println("Ошибка: количество иконок неверное");
        }
        for (WebElement icon : icons) {
            String src = icon.getAttribute("src");
            boolean found = false;
            for (String system : paymentSystems) {
                if (src.contains(system)) {
                    System.out.println("Иконка " + system + " найдена");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.err.println("Ошибка: неопознанная иконка платежной системы");
            }
        }

    }

    public void checkLinkWork() throws InterruptedException {
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        if ((driver.findElement(By.linkText("Подробнее о сервисе")).isEnabled())) {
            link.click();
            Thread.sleep(4000);
            if (!(driver.getCurrentUrl().equals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"))) {

                System.out.println("Ошибка: ссылка «Подробнее о сервисе» не работает.");
            }
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().back();
        js.executeScript("window.stop()");
        driver.navigate().refresh();
    }

}
