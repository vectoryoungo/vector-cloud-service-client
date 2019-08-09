/**
 * @create 2019-08-09 11:02
 * @desc implement FeignClientNoExtends
 **/
package com.ch.vector.lab.client.service;

import com.asia.stupid.fucking.shit.api.pojo.UserFeignPOJO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeignClientNoExtendsImpl implements FeignClientNoExtends{

    @Override
    public List<String> testCall() {

        List<String> fallback = new ArrayList<>(2);
        fallback.add("Fallback invoke ....");
        return fallback;
    }

    @Override
    public UserFeignPOJO getByID(Long id) {
        return new UserFeignPOJO(0L,"Fallback");
    }

    @Override
    public UserFeignPOJO getByIdPost(Long id) {
        return new UserFeignPOJO(0L,"Fallback");
    }

    @Override
    public UserFeignPOJO add(Long id, String name) {
        return new UserFeignPOJO(0L,"Fallback");
    }

    @Override
    public UserFeignPOJO add(UserFeignPOJO userFeignPOJO) {
        return new UserFeignPOJO(0L,"Fallback");
    }
}

