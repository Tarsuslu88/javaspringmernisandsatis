package com.dersler.new_play_sales.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="Product_Name")
    private String productName;

    @Column(name="Sales_Quantity")
    private int salesQuantity;

    @OneToMany
    @JoinColumn(name = "id", referencedColumnName = "id")
    List<Campaign> campaignId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Customer customer;

}
