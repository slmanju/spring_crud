package com.manjula.crud.service.impl;

import com.manjula.crud.model.Employee;
import com.manjula.crud.repository.EmployeeRepository;
import com.manjula.crud.service.EmployeeService;
import com.manjula.crud.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by manjula on 10/23/17.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(EmployeeView view) {
        employeeRepository.save(Employee.valueOf(view));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
