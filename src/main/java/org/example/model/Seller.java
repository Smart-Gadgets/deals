package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Seller {
    @Id
    private String userId;
    private String name;
}
