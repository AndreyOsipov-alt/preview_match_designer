package ru.matchdecor.previewer.logic.manager.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import ru.matchdecor.previewer.dto.model.RequestSearch;
import ru.matchdecor.previewer.logic.manager.SearchManager;
import ru.matchdecor.previewer.util.WebDriverConfig;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class SearchManagerImpl implements SearchManager {

    private String plumbingUrl = "https://www.vseinstrumenti.ru"; //TODO для ВсехИнструментов работает для большинства видов товаров

    private  final WebDriver webDriver;


    @Override
    public List<RequestSearch> plumbingSearch(String searchString) {
        String requestUrl = String.format(
            plumbingUrl + "/search/?what=%s",
            searchString
        );
        log.info(requestUrl);
        List<RequestSearch> productList = new ArrayList<>();

        //TODO решить вопрос: с первого раза страница не открывается, необходимо два раза дергать метод.
        try {
            webDriver.get(requestUrl);

            List<WebElement> productLinks = webDriver.findElements(By.xpath(".//div[@data-qa='products-tile']"));
            log.info(String.valueOf(productLinks.size()));
            for (WebElement link : productLinks) {
                RequestSearch result = new RequestSearch();
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
}
