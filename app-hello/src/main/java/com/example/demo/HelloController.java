package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author : wangtao
 * @date : 2018/1/29 17:14
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    @Value("${appname}")
    private String appname;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;


    @Autowired
    private DiscoveryClient client;

    @Autowired
    private Registration registration;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        String description = client.description();
        System.out.println("description = " + description);
        String serviceId = registration.getServiceId();
        System.out.println("serviceId = " + serviceId);
        URI uri = registration.getUri();
        System.out.println("uri = " + uri);
        String host = registration.getHost();
        System.out.println("host = " + host);
        List<ServiceInstance> instances = client.getInstances(serviceId);
        for (String s : client.getServices()) {
            System.out.println("s = " + s);
        }
        return "hello server";
    }

    @RequestMapping("/app")
    public String appname() {
        Map<String, String> map = new HashMap<>(3);
        map.put("password", password);
        map.put("username", username);
        map.put("appname", appname);
        return JSON.toJSONString(map);
    }
}
