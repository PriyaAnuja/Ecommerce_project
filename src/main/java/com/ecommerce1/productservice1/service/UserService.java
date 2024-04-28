package com.ecommerce1.productservice1.service;

import com.ecommerce1.productservice1.dtos.GetInstructorDto;
import com.ecommerce1.productservice1.models.Instructor;
import com.ecommerce1.productservice1.models.User;
import com.ecommerce1.productservice1.models.Batch;
import com.ecommerce1.productservice1.repository.InstructorRepository;
import com.ecommerce1.productservice1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;


@Service
public class UserService {
    private final UserRepository userRepository;
    public final InstructorRepository instructorRepository;

    public UserService(UserRepository userRepository, InstructorRepository instructorRepository) {
        this.userRepository = userRepository;
        this.instructorRepository=instructorRepository;
    }

    public User createUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }

    public Instructor createInstructor(String name, String email){
        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setSalary(200000.0);
        instructor.setSkills("Backend");
        instructorRepository.save(instructor);
        return instructor;
    }

    public List<User> getUserByName(String name) {

        return userRepository.findByName(name);
    }

    public List<GetInstructorDto> getInstructorByName(String name){
        List<Instructor> instructors = instructorRepository.findByName(name);

        List<GetInstructorDto> instructorDtos = new ArrayList<>();
        for(Instructor instructor: instructors){
            GetInstructorDto getInstructorDto = new GetInstructorDto();
            getInstructorDto.setId(instructor.getId());
            getInstructorDto.setName(instructor.getName());
            getInstructorDto.setEmail(instructor.getEmail());

            List<String> batchNames = new ArrayList<>();
            List<Long> ids = new ArrayList<>();
            for(Batch batch: instructor.getBatch()){
                batchNames.add(batch.getName());
                ids.add(batch.getId());
            }
            getInstructorDto.setBatchName(batchNames);
            getInstructorDto.setBatchId(ids);
            instructorDtos.add(getInstructorDto);
        }
        return instructorDtos;
    }
}
