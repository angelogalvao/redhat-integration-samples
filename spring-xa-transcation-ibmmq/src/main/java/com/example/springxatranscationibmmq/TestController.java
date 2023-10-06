package com.example.springxatranscationibmmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/test/javaee/run")
    @Transactional(propagation = Propagation.REQUIRED)
    public String runTestJavaEE() {


        databaseService.doSomethingTransacted();

        
        messageService.sendMessageJavaEE();

        return "TEST JAVA EE RAN!";
    }

    @GetMapping("/test/spring/run")
    @Transactional(propagation = Propagation.REQUIRED)
    public String runTestSpring() {


        databaseService.doSomethingTransacted();

        
        messageService.sendMessageSpring();

        return "TEST SPRING RAN!";
    }
}
