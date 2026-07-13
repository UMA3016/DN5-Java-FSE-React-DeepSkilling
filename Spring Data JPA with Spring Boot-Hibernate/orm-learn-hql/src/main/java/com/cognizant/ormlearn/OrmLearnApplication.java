package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        LOGGER.info("Inside Main");

        employeeService = context.getBean(EmployeeService.class);

        // Hands-on 2 - HQL
        testGetPermanentEmployees();
    }

    private static void testGetPermanentEmployees() {

        LOGGER.info("Start");

        List<Employee> employees =
                employeeService.getPermanentEmployees();

        LOGGER.info("Permanent Employees = {}", employees);

        LOGGER.info("End");
    }
}