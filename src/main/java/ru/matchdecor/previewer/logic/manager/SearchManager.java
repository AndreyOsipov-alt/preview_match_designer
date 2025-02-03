package ru.matchdecor.previewer.logic.manager;

import java.util.List;

import ru.matchdecor.previewer.dto.model.RequestSearch;

/**
 * @author aosipov
 * @since 03.02.2025
 */

public interface SearchManager {

    List<RequestSearch> plumbingSearch(String searchString);
}
