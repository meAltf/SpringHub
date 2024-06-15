package com.learn.restapi.SpringHub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String streetName;

    @Column(name = "city")
    private String cityName;

    @OneToOne(mappedBy = "address")
    private Student student;
}
