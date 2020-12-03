package com.exam.crm.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
//@Table(name = "user")
@Component
public class User {
    @Id
    private String id;
    private String password;
    private String name;
    /**
     * 0: Super user    (Access to all functions)
     * 1: Manager       (modify/delete/view company/client)
     * 2: Operator      (create/view company/client)
     */
    private byte permission;
    private Date created_at;
}
