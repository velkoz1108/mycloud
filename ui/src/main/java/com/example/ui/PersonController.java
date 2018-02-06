package com.example.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : want
 * @date : 2018/2/6 18:24
 */
@RestController
public class PersonController {
    @RequestMapping("/person")
    public Person person() {
        return new Person(1L, "WANG", "shanghai");
    }
}
