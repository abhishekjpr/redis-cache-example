package com.rediscache.rediscachetest.service.impl;

import com.rediscache.rediscachetest.dao.EmployeeRepository;
import com.rediscache.rediscachetest.model.Employees;
import com.rediscache.rediscachetest.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    @Override
    public void dataCacheToRedis(String employeeId) {

        try {
            Employees employees = (Employees) redisTemplate.opsForValue().get(employeeId);
            if (null != employees) {
                log.info("[dataCacheToRedis] Data received from Redis : {}", employees);
            } else {
                employees = employeeRepository.findAllByEmpNo(Integer.parseInt(employeeId));
                redisTemplate.opsForValue().set(employeeId, employees);
            }
        } catch (Exception exception) {
            log.error("[dataCacheToRedis] Exception occurred.", exception);
        }
    }

    @Override
    public void updateEmployeeDetails(String employeeId) {
        Integer empId = Integer.parseInt(employeeId);
        if(empId != null) {
            employeeRepository.updateEmployeeDetail(empId);
            Employees employees = employeeRepository.findAllByEmpNo(Integer.parseInt(employeeId));
            redisTemplate.opsForValue().set(empId+"", employees);
        }
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
}
