package com.manjula.crud.controller;

import com.manjula.crud.model.Employee;
import com.manjula.crud.service.EmployeeService;
import com.manjula.crud.view.EmployeeView;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by manjula on 10/23/17.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee/list";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("employee", EmployeeView.instance());
        model.addAttribute("roles", employeeService.findAllRoles());
        return "employee/save";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(EmployeeView view) {
        employeeService.save(view);
        return "redirect:/employee";
    }

}
