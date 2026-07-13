package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        LOGGER.info("Inside Main");

        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);

        // -------------------------------
        // Country Hands-on
        // -------------------------------
        testGetAllCountries();
        testGetCountry();
        testAddCountry();

        // -------------------------------
        // Employee Hands-on
        // -------------------------------
        // testAddEmployee(); // Commented because Employee entity has changed

        // -------------------------------
        // Query Methods Hands-on
        // -------------------------------
        testSearchCountry();
        testSearchCountrySorted();
        testCountriesStartingWith();

        // -------------------------------
        // O/R Mapping Hands-on
        // -------------------------------
        testGetCountryWithCurrency();

        // -------------------------------
        // HQL Hands-on 2
        // -------------------------------
        testGetPermanentEmployees();
    }

    private static void testGetAllCountries() {

        LOGGER.info("Start");

        List<Country> countries = countryService.getAllCountries();

        LOGGER.info("Countries = {}", countries);

        LOGGER.info("End");
    }

    private static void testGetCountry() {

        LOGGER.info("Start");

        Country country = countryService.getCountry("IN");

        LOGGER.info("Country = {}", country);

        LOGGER.info("End");
    }

    private static void testAddCountry() {

        LOGGER.info("Start");

        Country country = new Country("UK", "United Kingdom");

        countryService.addCountry(country);

        LOGGER.info("Country Added Successfully");

        LOGGER.info("End");
    }

    // Old Employee Hands-on
    // Commented because Employee model has changed
    /*
    private static void testAddEmployee() {

        LOGGER.info("Adding Employee...");

        Employee employee = new Employee(
                null,
                "Kiran",
                "Developer",
                65000
        );

        employeeService.addEmployee(employee);

        LOGGER.info("Employee Added Successfully");
    }
    */

    private static void testSearchCountry() {

        LOGGER.info("Start");

        List<Country> countries =
                countryService.searchCountry("ou");

        LOGGER.info("Countries = {}", countries);

        LOGGER.info("End");
    }

    private static void testSearchCountrySorted() {

        LOGGER.info("Start");

        List<Country> countries =
                countryService.searchCountrySorted("ou");

        LOGGER.info("Countries = {}", countries);

        LOGGER.info("End");
    }

    private static void testCountriesStartingWith() {

        LOGGER.info("Start");

        List<Country> countries =
                countryService.getCountriesStartingWith("Z");

        LOGGER.info("Countries = {}", countries);

        LOGGER.info("End");
    }

    private static void testGetCountryWithCurrency() {

        LOGGER.info("Start");

        Country country = countryService.getCountry("IN");

        LOGGER.info("Country = {}", country);

        LOGGER.info("Currency = {}", country.getCurrency());

        LOGGER.info("End");
    }

    // Hands-on 2 - HQL
    private static void testGetPermanentEmployees() {

        LOGGER.info("Start");

        List<Employee> employees =
                employeeService.getPermanentEmployees();

        LOGGER.info("Permanent Employees = {}", employees);

        LOGGER.info("End");
    }
}