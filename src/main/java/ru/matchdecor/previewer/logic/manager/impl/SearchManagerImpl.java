package ru.matchdecor.previewer.logic.manager.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import ru.matchdecor.previewer.consts.Integration;
import ru.matchdecor.previewer.dto.model.ResponceSearch;
import ru.matchdecor.previewer.logic.manager.SearchManager;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class SearchManagerImpl implements SearchManager {


    private  final WebDriver webDriver;


    /**
     * Поиск сантехники на сайте "Все инструменты.ру"
     * searchString - поисковая строка
     * При открытии страницы, загружается болванка с просьбой обновить страницу,
     * для получения результата нужно дергать два раза
     */
    @Override
    public List<ResponceSearch> plumbingSearchVseIstrumenti(String searchString) {
        String requestUrl = String.format(
            Integration.plumbing.get("vse_instr") + "/search/?what=%s",
            searchString
        );
        log.info(requestUrl);
        List<ResponceSearch> productList = new ArrayList<>();
        //TODO при вызове: с первого раз а страница не открывается
        try {
            webDriver.get(requestUrl);


            List<WebElement> productLinks = webDriver.findElements(By.xpath(".//div[@data-qa='products-tile']"));
            log.info(String.valueOf(productLinks.size()));
            for (WebElement link : productLinks) {
                ResponceSearch result = new ResponceSearch();
                String productLink = link.findElement(By.xpath(".//a[@data-qa='product-name']")).getAttribute("href");
                String productName = link.findElement(By.xpath(".//a[@data-qa='product-name']")).getAttribute("title");
                String price = link.findElement(By.xpath(".//p[@data-qa='product-price-current']")).getText();
                result.setLink(productLink);
                result.setNameProduct(productName);
                result.setPrice(price);

                productList.add(result);

            }

        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        return productList;
    }

    /**
     * Поиск сантехники на сайте "Сантехника-Онлайн"
     * searchString - поисковая строка
     * При открытии сайта, ожидаем появления кнопки принятия Cookie ->
     * принимаем -> парсим страницу.
     * Срабатывает единожды при входе.
     */
    @Override
    public List<ResponceSearch> plumbingSearchSantOnline(String searchString) {

        String requestUrl = String.format(
            Integration.plumbing.get("sant_online") + "/search/?q=%s&search_provider=anyquery",
            searchString
        );
        log.info(requestUrl);
        List<ResponceSearch> productList = new ArrayList<>();

        try {
            webDriver.get(requestUrl);
            if(existElement(".//button[@class='btn btn--primary btn--lg btn--full-width']"))
            {
                webDriver.findElement(By.xpath(".//button[@class='btn btn--primary btn--lg btn--full-width']")).click();
            }

           List<WebElement> elements = webDriver.findElements(By.xpath(".//div[@class='_NCpn8krGs4Bwe5gHJHw small-tiles']"));
            log.info(String.valueOf(elements.size()));
            for (WebElement element : elements) {
                ResponceSearch result = new ResponceSearch();
                result.setNameProduct(element.findElement(By.xpath("./child::div/a")).getText());
                result.setPrice(element.findElement(By.xpath("./child::div/div[2]/div[1]")).getText());
                //old-price "./child::div/div[2]/div[2]"
                result.setLink(element.findElement(By.xpath(".//a")).getAttribute("href"));
                productList.add(result);

            }

        } catch(Exception e) {
            throw new RuntimeException(e);
        }

        return productList;
    }

    private boolean existElement(String xPath) {
        try{
            webDriver.findElement(By.xpath(xPath));
        } catch(NoSuchElementException e) {
            return false;
        }
        return true;

    }
}
