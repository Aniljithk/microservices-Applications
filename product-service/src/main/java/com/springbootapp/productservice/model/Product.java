package com.springbootapp.productservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends UuidIdentifiedEntity {
    private String name;
    private String description;
    private BigDecimal price;
}
