package com.snowflex.snowflack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "street")
    private  String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private  String state;

    @Column(name = "country")
    private  String country;

    @Column(name = "zip_code")
    private  String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;


}
