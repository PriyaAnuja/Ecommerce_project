package com.ecommerce1.productservice1.repository;

import com.ecommerce1.productservice1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    //Optional<User> findById(Long aLong);

    List<User> findByName(String name);

    //List<User> findAllByNameEndingWith(String suffix);

    //User save(User entity);
}
