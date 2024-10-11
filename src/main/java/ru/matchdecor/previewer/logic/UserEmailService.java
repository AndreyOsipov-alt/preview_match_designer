package ru.matchdecor.previewer.logic;

import ru.matchdecor.previewer.dto.model.RequestEmail;

public interface UserEmailService {

    String saveUserEmail(RequestEmail request);
}
