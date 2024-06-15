package com.umg.examen.repositories;


import com.umg.examen.entities.Authority;
import com.umg.examen.entities.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    public Authority findByName(AuthorityName name);
}