package com.exam.crm.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
//@Table(name = "client")
@Component
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int company_id;
    private String name;
    private String email;
    private String phone;
    private String created_by;
    private Date created_at;
    private String updated_by;
    private Date updated_at;
}
