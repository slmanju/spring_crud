package com.manjula.crud.view;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
public class RoleView {

    private String id;
    private String name;

    public static RoleView instance() {
        return new RoleView();
    }

}
