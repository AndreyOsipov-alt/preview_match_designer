package ru.matchdecor.previewer.logic.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.matchdecor.previewer.dto.model.ResponceSearch;
import ru.matchdecor.previewer.logic.manager.SearchManager;
import ru.matchdecor.previewer.logic.service.SearchService;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    private final SearchManager searchManager;

    @Override
    public List<ResponceSearch> search(String searchString) {

        List<ResponceSearch> results = searchManager.plumbingSearchVseIstrumenti(searchString);
        //TODO пока что запросы с разных сайтов будут вызываться тут одтельно, если это разрастется перенести это в SearchManager.
        //TODO Добавить сортировку от дешевого до дорого товара
        //TODO Реализация фильтрации товаров.
        return results;
    }
}
