package ru.matchdecor.previewer.util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import jakarta.annotation.PreDestroy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@Component
@Lazy
public class WebDriverConfig {

    private  WebDriver driver;

    @Bean
    public  WebDriver webDriver() {
        if(driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
            //options.addArguments("--headless"); // Запуск без интерфейса браузера (фоновый режим)
            //options.addArguments("--disable-gpu"); // Отключение GPU (для совместимости)

            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }



    @PreDestroy
    public void closeDriver() {
       if(driver != null) {
           driver.quit();
           driver.close();
           System.out.println("Драйвер закрыт");
       }
    }
}
