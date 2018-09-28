package com.enshub.elk.controller;

import com.enshub.elk.model.Employee;
import com.enshub.elk.repository.EmployeeRepository;
import com.enshub.elk.viewmodel.EmployeeViewmodel;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/es")
@Api(value = "ES demo")
public class ElasticSearchController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //增加
    @PostMapping("/add")
    public String add(@RequestBody EmployeeViewmodel request){
        Employee employee=new Employee();
        BeanUtils.copyProperties(request,employee);
        employeeRepository.save(employee);

        System.err.println("add a obj");

        return "success";
    }

    //删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){

        employeeRepository.deleteById(id);

        return "success";
    }

    //局部更新
    @PostMapping("/update")
    public String update(@RequestBody EmployeeViewmodel request){

        Employee employee=employeeRepository.findById(request.getId()).get();
        BeanUtils.copyProperties(request,employee);
        employeeRepository.save(employee);
        System.err.println("update a obj");

        return "success";
    }

    //查询
    @GetMapping("/query/{id}")
    public Employee query(@PathVariable("id") String id){
        Employee accountInfo=employeeRepository.findById(id).get();
        return accountInfo;
    }

}

