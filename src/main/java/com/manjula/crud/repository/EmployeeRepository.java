package com.manjula.crud.repository;

import com.manjula.crud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manjula on 10/23/17.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
