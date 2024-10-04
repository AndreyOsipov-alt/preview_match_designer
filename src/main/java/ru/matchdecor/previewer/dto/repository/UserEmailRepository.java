package ru.matchdecor.previewer.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.matchdecor.previewer.dto.entity.UserEmail;

import java.util.Optional;

@Repository
public interface UserEmailRepository extends JpaRepository<UserEmail, Long> {

    Optional<UserEmail> findByEmail(String email);
}
