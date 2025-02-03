package ru.matchdecor.previewer.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.matchdecor.previewer.dto.model.RequestEmail;
import ru.matchdecor.previewer.logic.service.UserEmailService;

@RestController
@RequestMapping(value = "/email")
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private  final UserEmailService userEmailService;


    @PostMapping(path = "/send")
    public String sendEmail(@RequestBody RequestEmail request) {
        log.info("controller: " + request.getEmail());
        return  userEmailService.saveUserEmail(request);
    }
}
