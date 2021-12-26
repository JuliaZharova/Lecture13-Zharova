import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String searchFieldXpath = "//input[@type=\"text\"]";
        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("rozetka ua");
        System.out.println("Search field is displayed " + searchElement.isDisplayed());
        searchElement.submit();

        WebElement searchResults = driver.findElement(By.xpath("//div[@class='yuRUbf']//a[@href='https://rozetka.com.ua/']//h3[@class='LC20lb MBeuO DKV0Md']"));
        searchResults.click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());

        WebElement searchField = driver.findElement(By.xpath("//input[@class]"));
        searchField.click();
        searchField.sendKeys("карамель соленая spell с ванилью 500");
        System.out.println("Search field is displayed " + searchField.isDisplayed());

        WebElement searchButton = driver.findElement(By.xpath("//button[@class=\"button button_color_green button_size_medium search-form__submit ng-star-inserted\"]"));
        searchButton.click();
        System.out.println("Current URL after click is " + driver.getCurrentUrl());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement chooseProduct = driver.findElement(By.xpath("//img[@src=\"https://content2.rozetka.com.ua/goods/images/big_tile/27924167.jpg\"]"));
        System.out.println("Search product is displayed " + chooseProduct.isDisplayed());
        System.out.println("Product name " + driver.getTitle());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        chooseProduct.click();
        //Thread.sleep(3500);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement buyButton = driver.findElement(By.xpath("//div[2]/rz-product-main-info/div[2]/div/ul/li[1]/app-product-buy-btn/app-buy-button/button"));
        System.out.println("Search button is displayed " + buyButton.isDisplayed());
        buyButton.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.close();
    }
}
