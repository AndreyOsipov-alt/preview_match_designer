package ru.matchdecor.previewer.dto.model;

import lombok.Data;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@Data
public class ResponceSearch {

    private String nameProduct;
    private String price;
    private String link;
    //TODO добавить старую цену если такая имеется, много товаров указывается с учетом скидки + старая цена. На данный момент указывается актуальная цена.

}
