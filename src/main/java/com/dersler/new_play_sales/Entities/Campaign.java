package com.dersler.new_play_sales.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="campaigns")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="Compaign_Name")
    private String campaignName;

    @Column(name="Description")
    private String description;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Sales sales;

}
