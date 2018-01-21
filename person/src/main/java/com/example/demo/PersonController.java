package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangtao
 * @date : 2018/1/19 13:51
 */
@RestController
public class PersonController {
    @RequestMapping("/index")
    public String index() {
        return "in person idnex";
    }
}
