package com.gk.minidaodemo.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "city")
public class city {
    @Id
    private Integer ID;
    @Column(name = "Name",nullable = true)
    private String Name;
    @Column(name = "CountryCode",nullable = true)
    private String CountryCode;
    @Column(name = "District",nullable = true)
    private String District;
    @Column(name = "Population",nullable = true)
    private Integer Population;

}
