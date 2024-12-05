import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SaucedemoTest {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        //WebDriver driver = new ChromeDriver();
        //System.setProperty("webdriver.edge.driver", "path/to/chromedriver");
        WebDriver driver = new EdgeDriver();

        try {
            // Navegar a la página
            driver.get("https://www.saucedemo.com/");

            // Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Seleccionar un producto
            driver.findElement(By.cssSelector(".inventory_item:nth-child(1) .btn_inventory")).click();

            // Ir al carrito
            driver.findElement(By.className("shopping_cart_link")).click();

            // Completar la compra
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("Cesar");
            driver.findElement(By.id("last-name")).sendKeys("Alva");
            driver.findElement(By.id("postal-code")).sendKeys("15106");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();

            // Volver a Home
            driver.findElement(By.id("back-to-products")).click();

        } finally {
            // Cerrar navegador
            driver.quit();
        }
    }
}