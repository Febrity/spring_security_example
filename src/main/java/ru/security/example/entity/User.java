package ru.security.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Getter
    @Setter
    @Size(max = 256)
    private String userName;

    @Getter
    @Setter
    @Size(max = 256)
    private String password;

    @Getter
    @Setter
    @Size(max = 256)
    private String passwordEncode;

    @Getter
    @Setter
    @Size(max = 256)
    private String role;
}
