package com.exam.crm.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserInfo {
    private String id;
    private String name;
    /**
     * 0: Super user    (Access to all functions)
     * 1: Manager       (modify/delete/view company/client)
     * 2: Operator      (create/view company/client)
     */
    private byte permission;
}
