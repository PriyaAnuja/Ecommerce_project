package com.ecommerce1.productservice1.dtos;

import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GetInstructorDto {
    private UUID id;
    private String name;
    private String email;
    private List<String> batchName;
    private List<Long> batchId;
}
