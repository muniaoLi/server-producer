package com.muniao.serverproducer.controller;

import com.muniao.serverproducer.vo.UserVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//这里面的属性有可能会更新的，git中的配置中心变化的话就要刷新，没有这个注解内，配置就不能及时更新
@RefreshScope
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

    @Value("${hello.msg}")
    private String helloMsg;

    @RequestMapping("/helloConfig")
    public String helloConfig() {
        return this.helloMsg;
    }

}
