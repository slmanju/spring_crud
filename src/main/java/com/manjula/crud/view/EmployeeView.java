package com.manjula.crud.view;

import lombok.Data;
import lombok.ToString;

/**
 * Created by manjula on 10/23/17.
 */
@Data
@ToString
public class EmployeeView {

    private String id;
    private String username;
    private String firstName;
    private String lastName;

    public static EmployeeView instance() {
        return new EmployeeView();
    }

}
