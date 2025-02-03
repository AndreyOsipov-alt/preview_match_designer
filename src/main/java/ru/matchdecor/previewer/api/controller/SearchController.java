package ru.matchdecor.previewer.api.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matchdecor.previewer.dto.model.RequestSearch;
import ru.matchdecor.previewer.logic.manager.SearchManager;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@RestController
@RequestMapping(value = "/search")
@RequiredArgsConstructor
@Slf4j
public class SearchController {
    private final SearchManager searchManager;

    @PostMapping(path = "/{searchString}")
    public ResponseEntity<List<RequestSearch>> search(@PathVariable String searchString) {
        //TODO получение списка перенести в SearchServiceImpl там уже добавить фильтрацию и сортировку, здесь вызывать searchService
       return ResponseEntity.ok(searchManager.plumbingSearch(searchString));

    }
}
