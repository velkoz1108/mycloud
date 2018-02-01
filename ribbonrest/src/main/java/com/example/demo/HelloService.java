package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.deploy.net.proxy.pac.PACFunctions;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : wangtao
 * @date : 2018/1/22 11:48
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    // ------------------------------------------------------------------------------GET-------------------------------------------------
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


    public String hi() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://HELLO-SERVER/hello?name={1}", String.class, "my name");
        String body = forEntity.getBody();
        return body;
    }

    public String hiUser() {
        ResponseEntity<Person> forEntity = restTemplate.getForEntity("http://HELLO-SERVER/user?id={1}", Person.class, "my name");
        Person user = forEntity.getBody();
        return user.toString();
    }

    public String hiMap() {
        Map<String, String> param = new HashMap<>(1);
        param.put("name", "www");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://HELLO-SERVER/user?name={name}", String.class, param);
        String user = forEntity.getBody();
        return user;
    }

    public String hiBuild() {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVER/user?name={name}")
                .build()
                .expand("test")
                .encode();
        URI uri = uriComponents.toUri();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(uri, String.class);
        String user = forEntity.getBody();
        return user;
    }

    // ------------------------------------------------------------------------------POST-------------------------------------------------
    public String postEntity() {
        Person person = new Person("www", "eeee");
        ResponseEntity<String> ret = restTemplate.postForEntity("http://HELLO-SERVER/user", person, String.class);
        return ret.getBody();
    }

    public String postObject() {
        Person person = new Person("www", "eeee");
        String ret = restTemplate.postForObject("http://HELLO-SERVER/user", person, String.class);
        return ret;
    }

    public String postLocation() {
        Person person = new Person("www", "eeee");
        //返回新资源的URI
        URI uri = restTemplate.postForLocation("http://HELLO-SERVER/user", person);
        String s = restTemplate.patchForObject(uri, person, String.class);
        return s;
    }

    // ------------------------------------------------------------------------------PUT-------------------------------------------------
    public void put() {
        Person person = new Person("www", "eeee");
        //没有返回值的  请求服务器存储一个资源，并用Request-URI作为其标识
        restTemplate.put("http://HELLO-SERVER/user/{1}/{2}", person, "aaa", "nnn");
    }

    // ------------------------------------------------------------------------------DELETE-------------------------------------------------
    public void delete() {
        restTemplate.delete("http://HELLO-SERVER/user/{1}", "1111");
    }
}
