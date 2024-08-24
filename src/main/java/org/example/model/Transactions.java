package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Transactions {

    @Id
    private Long transaction_Id;
    private String userId;
    private String dealId;
    private String itemId;

}
