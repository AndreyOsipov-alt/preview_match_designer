package ru.matchdecor.previewer.logic.service;

import java.util.List;

import ru.matchdecor.previewer.dto.model.ResponceSearch;

/**
 * @author aosipov
 * @since 03.02.2025
 */

public interface SearchService {

    //TODO поменять на ResponceSearch
    List<ResponceSearch> search(String searchString);
}
