package com.rediscache.rediscachetest.controller;

import com.rediscache.rediscachetest.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RedisController {

    @RequestMapping(value = "/cacheData", method = RequestMethod.POST)
    public void dataCache(@RequestBody String employeeId) {
        log.info("[dataCache] Request received : {}", employeeId);
        redisService.dataCacheToRedis(employeeId);
    }

    @RequestMapping(value = "/updateData", method = RequestMethod.POST)
    public void updateData(@RequestBody String employeeId){
        log.info("[updateData] Request received : {}", employeeId);
        redisService.updateEmployeeDetails(employeeId);
    }
    @Autowired
    RedisService redisService;
}
