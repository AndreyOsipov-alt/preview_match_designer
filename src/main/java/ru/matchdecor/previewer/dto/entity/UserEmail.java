package ru.matchdecor.previewer.dto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="t_user_email", schema = "user_management")
public class UserEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_email")
    private String email;

    @Column(name = "c_user_id")
    private String userId;
}
