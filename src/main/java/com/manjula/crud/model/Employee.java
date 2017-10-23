package com.manjula.crud.model;

import com.manjula.crud.view.EmployeeView;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by manjula on 10/23/17.
 */
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String username;
    private String firstName;
    private String lastName;

    public static Employee valueOf(EmployeeView view) {
        Employee employee = new Employee();
        employee.setUsername(view.getUsername());
        employee.setFirstName(view.getFirstName());
        employee.setLastName(view.getLastName());
        return employee;
    }

}
