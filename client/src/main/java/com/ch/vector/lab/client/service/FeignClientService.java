/**
 * @create 2019-08-06 10:58
 * @desc feign client service
 **/
package com.ch.vector.lab.client.service;

import com.asia.stupid.fucking.shit.api.service.UserFeignService;
import org.springframework.cloud.netflix.feign.FeignClient;

//@FeignClient(name = "vector-cloud-service-api-impl")
public interface FeignClientService extends UserFeignService{
}

