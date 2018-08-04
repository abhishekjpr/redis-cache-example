package com.rediscache.rediscachetest.service;

public interface RedisService {

    void dataCacheToRedis(String employeeId);

    void updateEmployeeDetails(String employeeId);
}
