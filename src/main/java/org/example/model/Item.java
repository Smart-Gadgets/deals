package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Item {
    @Id
    private Long id;

    private String itemName;
    private int count;
}
