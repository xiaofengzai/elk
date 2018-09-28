package com.enshub.elk.repository;


import com.enshub.elk.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;


@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {

}
