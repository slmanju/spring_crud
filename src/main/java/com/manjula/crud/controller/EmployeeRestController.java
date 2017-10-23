package com.manjula.crud.controller;

import com.manjula.crud.model.Employee;
import com.manjula.crud.service.EmployeeService;
import com.manjula.crud.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by manjula on 10/23/17.
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Employee> list() {
        return employeeService.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public EmployeeView save(EmployeeView view) {
        employeeService.save(view);
        return view;
    }

}
