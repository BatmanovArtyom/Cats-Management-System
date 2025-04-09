package com.tech.labs.DaoModule.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "colors")
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorID;
    private String colorName;

}
