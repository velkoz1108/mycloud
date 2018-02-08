package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author : wangtao
 * @date : 2018/1/22 13:23
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return "sorry " + name;
    }
}
