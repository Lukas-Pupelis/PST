import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

public class Main {
    @Test
    public void main() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        WebElement giftCardsButton = driver.findElement(By.xpath("//li[@class = \"inactive\"]//a[contains(text(), 'Gift Cards')]"));
        giftCardsButton.click();

        driver.findElement(By.xpath("//div[@class='product-item']//img[contains(@alt, '$') and number(substring-before(substring-after(@alt, '$'), ' ')) > 99]")).click();

        WebElement recipientName = driver.findElement(By.xpath("//input[@class = \"recipient-name\"]"));
        recipientName.sendKeys("Auto recipient");

        driver.findElement(By.xpath("//input[@class = \"sender-name\"]")).sendKeys("Auto Sender");

        driver.findElement(By.xpath("//input[@id=\"addtocart_4_EnteredQuantity\"]")).clear();

        driver.findElement(By.xpath("//input[@id=\"addtocart_4_EnteredQuantity\"]")).sendKeys("5000");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-4\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id=\"add-to-wishlist-button-4\"]")).click();
        Thread.sleep(1000);

        //Jewelry
        driver.findElement(By.xpath("//li[@class = \"inactive\"]//a[contains(text(), 'Jewelry')]")).click();


        driver.findElement(By.xpath("//a[contains(text(), 'Create Your Own Jewelry')]")).click();

        driver.findElement(By.xpath("//select[@id=\"product_attribute_71_9_15\"]")).click();

        driver.findElement(By.xpath("//select/option[@value = \"47\"]"));

        driver.findElement(By.xpath("//input[@id=\"product_attribute_71_10_16\"]")).sendKeys("80");

        driver.findElement(By.xpath("//input[@id=\"product_attribute_71_11_17_50\"]")).click();

        driver.findElement(By.xpath("//input[@id=\"addtocart_71_EnteredQuantity\"]")).clear();

        driver.findElement(By.xpath("//input[@id=\"addtocart_71_EnteredQuantity\"]")).sendKeys("26");

        driver.findElement(By.xpath("//input[@id=\"add-to-cart-button-71\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id=\"add-to-wishlist-button-71\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[@class=\"cart-label\" and contains(text(), 'Wishlist')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//td[@class=\"add-to-cart\"]/input[@type=\"checkbox\"])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//td[@class=\"add-to-cart\"]/input[@type=\"checkbox\"])[2]")).click();

        driver.findElement(By.xpath("//input[@class=\"button-2 wishlist-add-to-cart-button\"]")).click();
        Thread.sleep(1000);

        String actual = driver.findElement(By.xpath("(//span[@class=\"product-price\"])[1]")).getText();
        double subTotal = Double.parseDouble(actual);
        assertEquals(1002600.00, subTotal);
        Thread.sleep(1000);

        driver.quit();
    }
}