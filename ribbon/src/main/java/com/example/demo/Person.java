package com.example.demo;

import com.alibaba.fastjson.JSON;

import static com.netflix.eureka.registry.Key.KeyType.JSON;

/**
 * @author : wangtao
 * @date : 2018/2/1 13:54
 */

public class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
