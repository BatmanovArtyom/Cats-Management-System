package com.tech.labs.DaoModule.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cats_friends")
public class CatsFriends {

    @Column (name ="catid")
    private Long catID;

    @Column (name ="friendid")
    private Long friendID;
    @Id
    private Long id;
}