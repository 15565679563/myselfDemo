package org.wlu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wlu.service.TestAsync;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestAsync testAsync;



    @GetMapping("/testSync")
    public String testSync(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("start");
        testAsync.test();
        System.out.println("end");
        return "testSync";
    }
}
