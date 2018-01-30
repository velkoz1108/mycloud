package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : wangtao
 * @date : 2018/1/22 11:48
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError") //断路由
    public String hiService(String name) {
//        String body = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
//        System.out.println("body = " + body);
        //如果配置文件中配置了以ip形式注册服务，这里就不行了，找不到服务
        return restTemplate.getForObject("http://HELLO-SERVER/hello", String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
}
