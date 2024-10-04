package ru.matchdecor.previewer.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.matchdecor.previewer.dto.exception.AlreadyExistException;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseBody
    public ResponseEntity<String> handleAlreadyExistException(AlreadyExistException ex) {
        log.debug("Mail already used");
        return new ResponseEntity<>("This email: %s already exist. Try again".formatted(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
