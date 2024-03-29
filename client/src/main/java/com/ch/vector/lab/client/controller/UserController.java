/**
 * @create 2019-08-06 10:57
 * @desc user enter
 **/
package com.ch.vector.lab.client.controller;

import com.asia.stupid.fucking.shit.api.pojo.UserFeignPOJO;
import com.ch.vector.lab.client.service.FeignClientNoExtends;
import com.ch.vector.lab.client.service.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    //@Autowired
    //private FeignClientService feignClientService;
    @Autowired
    private FeignClientNoExtends feignClientNoExtends;

    @GetMapping("/testCall")
    public List<String> testCall() {
        //return feignClientService.testCall();
        return feignClientNoExtends.testCall();
    }

    @GetMapping("/get")
    public UserFeignPOJO getByID(@RequestParam("id") Long id) {
        //return feignClientService.getByID(id);
        return feignClientNoExtends.getByID(id);
    }

    @PostMapping("/get")
    public UserFeignPOJO getByIdPost(Long id){
        //return feignClientService.getByIdPost(id);
        return feignClientNoExtends.getByIdPost(id);
    }


    @PostMapping("/add")
    public UserFeignPOJO add(Long aLong, String s){
        //return feignClientService.add(aLong,s);
        return feignClientNoExtends.add(aLong,s);
    }

    @PostMapping("/addJson")
    public UserFeignPOJO add(@RequestBody UserFeignPOJO userFeignPOJO) {
        //return feignClientService.add(userFeignPOJO);
        return feignClientNoExtends.add(userFeignPOJO);
    }

}

