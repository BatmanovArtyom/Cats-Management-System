package com.tech.labs.DaoModule.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "owners")
public class Owners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerID;
    private String ownerName;
    private String ownerBirthdate;
    @OneToMany(mappedBy = "owner")
    private List<Cats> listCats;
}