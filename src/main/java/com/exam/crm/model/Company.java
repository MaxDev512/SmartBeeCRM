package com.exam.crm.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
//@Table(name = "company")
@Component
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String created_by;
    private Date created_at;
    private String updated_by;
    private Date updated_at;
}
