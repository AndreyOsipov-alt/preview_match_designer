package ru.matchdecor.previewer.dto.exception;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException(){
        super();
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
