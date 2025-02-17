package ru.matchdecor.previewer.api.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matchdecor.previewer.dto.model.ResponceSearch;
import ru.matchdecor.previewer.logic.manager.SearchManager;
import ru.matchdecor.previewer.logic.service.SearchService;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@RestController
@RequestMapping(value = "/search")
@RequiredArgsConstructor
@Slf4j
public class SearchController {

    private final SearchService searchService;
    private  final SearchManager searchManager;

    @PostMapping(path = "/{searchString}")
    public ResponseEntity<List<ResponceSearch>> search(@PathVariable String searchString) {
       return ResponseEntity.ok(searchService.search(searchString));
    }

    @PostMapping(path = "/testSearch/{searchString}")
    public ResponseEntity<List<ResponceSearch>> testSearch(@PathVariable String searchString) {
        return ResponseEntity.ok(searchManager.plumbingSearchSantOnline(searchString));
    }
}
