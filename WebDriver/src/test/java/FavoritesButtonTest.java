import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class FavoritesButtonTest {

    WebDriver driver;
    WebElement favoriteBtn;
    @Before
    public final void setUpDriver(){
        driver = new ChromeDriver();
        driver.get("https://www.portative.by/myshki/mysh-provodnaya-usb-opticheskaya-a4tech-bloody-x5-max-s-podsvetkoy-9-knopok-10000-dpi-igrovaya-belaya");
        favoriteBtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/div[3]/div[1]/div/div[1]"));
        favoriteBtn.click();

    }
    @After
    public final void shutDownDriver(){
        driver.quit();
    }

    @Test
    public  void testChangeText() {
        String expected="В избранном";
        String actual=favoriteBtn.getText();
        Assert.assertEquals(expected, actual);
        System.out.println(favoriteBtn.getCssValue("color"));
    }

    @Test
    public void testChangeStyle(){
        String expectedClass="Favourites__Wrapper favourites-wrapper favourites-wrapper-active";
        String actualClass=favoriteBtn.getAttribute("class");
        Assert.assertEquals(expectedClass,actualClass);

    }
    @Test
    public void testCounterChanging(){
         WebElement span=driver.findElement(By.xpath("//*[@id=\"Header__Logo\"]/div[2]/div/div[1]/a[1]/span"));
         String expected="1";
         String actual=span.getText();
         Assert.assertEquals(expected,actual);
    }
    @Test
    public void testAddToFavorites(){
        WebElement favoriteHeart=driver.findElement(By.xpath("//*[@id=\"Header__Logo\"]/div[2]/div/div[1]/a[1]/span"));
        favoriteHeart.click();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        WebElement span =driver.findElement(By.xpath("//*[@id=\"elem_-423983\"]/div[4]/div/div[2]/div[1]/a/span"));
        String expected="Мышь проводная USB оптическая A4Tech Bloody X5 Max с подсветкой 9 кнопок 10000 dpi игровая черная";
        String actual=span.getText();
        Assert.assertEquals(expected, actual);
    }
}
