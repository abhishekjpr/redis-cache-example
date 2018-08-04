package com.rediscache.rediscachetest.dao;

import com.rediscache.rediscachetest.model.Employees;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employees, Integer> {

    List<Employees> findAll();

    Employees findAllByEmpNo(Integer employeeId);

    @Modifying
    @Transactional
    @Query(value = "update employees set first_name='Abhishek', last_name='Goyal', gender='M' where emp_no=?", nativeQuery = true)
    void updateEmployeeDetail(Integer empId);
}
