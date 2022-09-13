package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

//   interface  tip varijable    objekat
//         |         |              |
        WebDriver driver = new ChromeDriver(); //ova linija otvara browser
//        String url = "https://www.google.com";

        Thread.sleep(1500); //pomoćni alat za izvršavanje koda sa odgodom
        driver.manage().window().maximize(); //upravljanje browserom da se otvori u fullscreen
        Thread.sleep(2000);
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url); //unosi adresu u url
        Thread.sleep(1500);
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("tomsmith"); //uraditi isto za ostale korake, staviti u neku varijablu

        Thread.sleep(1500);
        //        driver.findElement(By.id("username"));
        Thread.sleep(1500);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");
        Thread.sleep(1500);
        driver.findElement(By.className("radius")).click();

        WebElement loggedInText = driver.findElement(By.id("flash"));
        System.out.println("Text u elementu: " + loggedInText.getText());
        System.out.println("Boja elemnta: " + loggedInText.getCssValue("background-color"));

        String actualBacgroundColor = loggedInText.getCssValue("background-color");

        String expectedText = "You logged into a secure area!";
        String expectedColor = "rgba(93, 164, 35, 1)";

        String actual [] = loggedInText.getText().split("(?<=!)"); //regex
        System.out.println("actual prvi " + actual[0]);
        System.out.println("actual drugi " + actual[1]);

        String actualText = actual [0];

        String actualText2 = loggedInText.getText().substring(0, loggedInText.getText().length() - 2);
        System.out.println("Actual 2: " + actualText2);
        Thread.sleep(3000);

        boolean result = expectedText.equals(actualText);
        Assert.assertTrue(result);

        Assert.assertEquals(actualText, expectedText);
        Assert.assertEquals(actualBacgroundColor, expectedColor);


//        if (actualText2.equals(expectedText)){
//            System.out.println("User je ulogovan");
//        }else {
//            System.out.println("Error");
//        }
//
//        if (actualBacgroundColor.equals(expectedColor)){
//            System.out.println("User je ulogovan");
//        }else {
//            System.out.println("Error");
//        }

        driver.quit();

        //Uhvatiti lokator sa tekstom nakon ulogovanja i ispisati text u konzoli

// CSS Locator cheat sheet - Upoznati se koje lokatore imamo, kako ih pronaći



        //testNG - Runner na osnovu kojeg ćemo pokretati projekte


    }

    @Test
    public void test(){
        System.out.println("Hello from test");
    }





}
