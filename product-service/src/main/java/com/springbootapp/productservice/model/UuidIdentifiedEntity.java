package com.springbootapp.productservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public abstract class UuidIdentifiedEntity {

    @Id
    protected UUID id;
}
