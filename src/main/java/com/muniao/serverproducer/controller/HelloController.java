package com.muniao.serverproducer.controller;

import com.muniao.serverproducer.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @Value("${server.port}")
    private int serverPort;

    @RequestMapping("/test")
    public String test() {
        return "test this is 1 messge";
    }

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+"，serverPort:"+serverPort;
    }

    @RequestMapping("/printUser")
    public String printUser(@RequestBody UserVO user)
    {
        System.out.println(user);
        return "hello name:"+user.getUserName()+" age:"+user.getAge()+" birthday:"+user.getBirthday()+"，serverPort:"+serverPort;
    }

}
