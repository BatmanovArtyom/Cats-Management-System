package com.tech.labs.DaoModule.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cats")
public class Cats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CatID;
    private String catName;
    private LocalDate сatBirthdate;

    @ManyToOne
    @JoinColumn(name = "ownerid")
    private Owners owner;

    @OneToOne
    @JoinColumn(name = "breed_id")
    private Breeds breed;

    @OneToOne
    @JoinColumn(name = "color_id")
    private Colors color;
}
