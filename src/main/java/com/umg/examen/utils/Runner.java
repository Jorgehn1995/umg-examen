package com.umg.examen.utils;


import com.umg.examen.entities.Authority;
import com.umg.examen.entities.AuthorityName;
import com.umg.examen.entities.User;
import com.umg.examen.repositories.AuthorityRepository;
import com.umg.examen.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository,
                  AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        this.authorityRepository.deleteAll();

        this.authorityRepository.saveAll(List.of(
                new Authority(AuthorityName.READ),
                new Authority(AuthorityName.WRITE),
                new Authority(AuthorityName.ADMIN),
                new Authority(AuthorityName.ROLE_USER),
                new Authority(AuthorityName.ROLE_ADMIN)
        ));
        User user = new User("admin",
                new BCryptPasswordEncoder().encode("password"),
                List.of(
                        this.authorityRepository.findByName(
                                AuthorityName.ADMIN
                        )
                )
        );
        this.userRepository.save(user);
    }
}