package com.workintech.burger.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="burger",schema="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="price",nullable = false)
    private double price;

    @Column(name="is_vegan")
    private boolean isVegan;

    @Column(name="bread_type")
    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name="contents")
    private String contents;
}
