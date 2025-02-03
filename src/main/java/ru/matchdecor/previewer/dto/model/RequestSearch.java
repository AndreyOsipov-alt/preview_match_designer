package ru.matchdecor.previewer.dto.model;

import lombok.Data;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@Data
public class RequestSearch {

    private String nameProduct;
    private String price;
    private String link;

}
