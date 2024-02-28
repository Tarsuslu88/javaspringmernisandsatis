package com.dersler.new_play_sales.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @Column(name="Year_Of_Birth")
    private int yearOfBirth;

    @Column(name="Nationality_Id")
    private String nationalityId;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id")
    private List<Sales> salesId;

}
