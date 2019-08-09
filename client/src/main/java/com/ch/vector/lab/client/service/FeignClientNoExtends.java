/**
 * @create 2019-08-09 10:58
 * @desc no extends feign
 **/
package com.ch.vector.lab.client.service;

import com.asia.stupid.fucking.shit.api.pojo.UserFeignPOJO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "vector-cloud-service-api-impl",fallback = FeignClientNoExtendsImpl.class)
public interface FeignClientNoExtends {

    @RequestMapping(value = "/testCall",method = RequestMethod.GET)
    public List<String> testCall();

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public UserFeignPOJO getByID(@RequestParam(value = "id")Long id);

    @RequestMapping(value = "/get",method = RequestMethod.POST)
    public UserFeignPOJO getByIdPost(@RequestBody Long id);

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public UserFeignPOJO add(@RequestParam("id")Long id,@RequestParam("name")String name);

    @RequestMapping(value = "/addJson",method = RequestMethod.POST)
    public UserFeignPOJO add(@RequestBody UserFeignPOJO userFeignPOJO);
}

