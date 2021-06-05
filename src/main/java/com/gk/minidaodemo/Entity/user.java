package com.gk.minidaodemo.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class user {
    @Id
    private Integer id;
    private String name;
    private String role;

}
