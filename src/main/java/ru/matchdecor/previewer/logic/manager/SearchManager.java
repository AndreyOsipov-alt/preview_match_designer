package ru.matchdecor.previewer.logic.manager;

import java.util.List;

import ru.matchdecor.previewer.dto.model.ResponceSearch;

/**
 * @author aosipov
 * @since 03.02.2025
 */
//TODO сделать декомпозицию вынести Менеджер и разбить его на сантехнику, мебель, электрику, фурнитуру
public interface SearchManager {

    List<ResponceSearch> plumbingSearchVseIstrumenti(String searchString);
    List<ResponceSearch> plumbingSearchSantOnline(String searchString);
}
