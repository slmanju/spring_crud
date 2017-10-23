package com.manjula.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by manjula on 10/23/17.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
