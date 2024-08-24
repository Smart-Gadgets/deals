package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Deal {
    @Id
    private String dealId;

    private String dealName;
    @OneToMany
    private List<Item> items;
    private Date endTime;
}
