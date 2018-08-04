package com.rediscache.rediscachetest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "employees")
@Entity
public class Employees implements Serializable {

    int empNo;
    Date birthDate;
    String firstName;
    String lastName;
    String gender;
    Date hireDate;

    @Id
    @Column(name = "empNo", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getEmpNo() {
        return empNo;
    }

    @Column(name = "birthDate", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    @Column(name = "gender", nullable = false)
    public String getGender() {
        return gender;
    }

    @Column(name = "hireDate", nullable = false)
    public Date getHireDate() {
        return hireDate;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
