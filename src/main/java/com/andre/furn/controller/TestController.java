package com.andre.furn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andre Wang
 * @version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String hi() {
        System.out.println("TestController-hi");
        return "hello";
    }
}
