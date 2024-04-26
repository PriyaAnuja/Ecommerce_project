package com.ecommerce1.productservice1.repository;

import com.ecommerce1.productservice1.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    List<Instructor> findByName(String name);
}
