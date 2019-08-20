package ru.security.example;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CreatePasswordBCryptPassword {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("admin"));
    }
}
