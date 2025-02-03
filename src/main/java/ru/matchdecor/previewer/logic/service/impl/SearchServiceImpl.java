package ru.matchdecor.previewer.logic.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.matchdecor.previewer.logic.service.SearchService;

/**
 * @author aosipov
 * @since 03.02.2025
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public String search(String searchString) {
/*        searchString -> в какой-нибудь менеджер, там кидаем запрос на сайт, получаем html
           html -> в класс utility парсим во что-нибудь, отправляем обратно сюда, и далле по цепочке
* */
        return null;
    }
}
