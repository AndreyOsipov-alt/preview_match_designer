package ru.matchdecor.previewer.logic.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.matchdecor.previewer.dto.entity.UserEmail;
import ru.matchdecor.previewer.dto.exception.AlreadyExistException;
import ru.matchdecor.previewer.dto.model.RequestEmail;
import ru.matchdecor.previewer.dto.repository.UserEmailRepository;
import ru.matchdecor.previewer.logic.service.UserEmailService;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserEmailServiceImpl implements UserEmailService {

    private final UserEmailRepository userEmailRepository;

    @Override
    public String saveUserEmail(RequestEmail request) {
        String email = request.getEmail();
        if (userEmailRepository.findByEmail(email).isPresent()) {
            throw new AlreadyExistException("This email already used");
        }
        if (email == null || email.isEmpty()) {
           return "Email can't be empty!";

        }

        log.info("Service: " + email);
        UserEmail userEmail = new UserEmail();
        userEmail.setEmail(email);
        userEmail.setDescription(request.getDescription());
        userEmailRepository.save(userEmail);



        return "Email is save";
    }
}
