package com.bridgelabz.springsecurityjwt;

import com.bridgelabz.springsecurityjwt.entity.User;
import com.bridgelabz.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(1, "Akanksha", "23", "9876543210","password", "akanksha@gmail.com"),
                new User(2, "Mahima", "22","5674832190","pwd1", "mahima@gmail.com"),
                new User(3, "Ved", "23", "1234567890","pwd2", "ved@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
