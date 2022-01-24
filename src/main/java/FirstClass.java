import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        WebElement searchElement = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        searchElement.sendKeys("rozetka ua");
        System.out.println("Search field is displayed " + searchElement.isDisplayed());
        searchElement.submit();

        WebElement searchResults = driver.findElement(By.xpath("//div[@class='yuRUbf']//a[@href='https://rozetka.com.ua/']//h3[@class='LC20lb MBeuO DKV0Md']"));
        searchResults.click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());

        WebElement searchField = driver.findElement(By.xpath("//input[@class=\"search-form__input ng-untouched ng-pristine ng-valid\"]"));
        searchField.click();
        searchField.sendKeys("карамель соленая spell с ванилью 500");
        System.out.println("Search field is displayed " + searchField.isDisplayed());

        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"button button_color_green button_size_medium search-form__submit ng-star-inserted\"]"));
        searchButton.click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());

        WebElement chooseProduct = driver.findElement(By.xpath("//li[1]//div[2]/a[2]"));
        System.out.println("Search product is displayed " + chooseProduct.isDisplayed());
        System.out.println("Product name " + driver.getTitle());
        chooseProduct.click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());
        Thread.sleep(2000);
        WebElement productTitle = driver.findElement(By.xpath("//h1"));
        productTitle.click();

        WebElement buyButton = driver.findElement(By.xpath("//button[@class=\"buy-button button button_with_icon button_color_green button_size_large ng-star-inserted\"]"));
        System.out.println("Buy button is enabled " + buyButton.isEnabled());
        buyButton.click();

        WebElement cartTitle = driver.findElement(By.xpath("//h3[@class=\"modal__heading\"]"));
        System.out.println("Cart is displayed: " + cartTitle.isDisplayed());
        System.out.println(cartTitle.getText());

        driver.close();
    }
}
