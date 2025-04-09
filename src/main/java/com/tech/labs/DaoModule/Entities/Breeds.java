package com.tech.labs.DaoModule.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "breeds")
public class Breeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breedID;
    private String breedName;

}
