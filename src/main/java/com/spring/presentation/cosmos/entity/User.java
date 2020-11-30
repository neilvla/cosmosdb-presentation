package com.spring.presentation.cosmos.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Container(containerName = "Users")
public class User {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    @PartitionKey
    private String lastName;
}