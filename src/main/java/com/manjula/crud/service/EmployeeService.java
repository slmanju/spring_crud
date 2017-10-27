package com.manjula.crud.service;

import com.manjula.crud.model.Employee;
import com.manjula.crud.view.EmployeeView;

import java.util.List;

/**
 * Created by manjula on 10/23/17.
 */
public interface EmployeeService {

    void save(EmployeeView employee);

    List<Employee> findAll();

    EmployeeView findByUsername(String username);

}
