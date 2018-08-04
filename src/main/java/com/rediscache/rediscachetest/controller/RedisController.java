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
        log.info("[dataCache] Called received.");
        redisService.dataCacheToRedis(employeeId);
    }

    @Autowired
    RedisService redisService;
}
