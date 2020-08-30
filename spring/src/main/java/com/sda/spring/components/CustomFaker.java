package com.sda.spring.components;

import com.github.javafaker.Faker;
import com.sda.spring.model.Company;
import com.sda.spring.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomFaker {

    public List<Employee> createDummyEmployeeList (){
        Faker faker = new Faker();
        List<Employee> dummyEmployee = new ArrayList<Employee>();

        for (int i =0; i<100;i++) {
            Employee employee = new Employee();
            employee.setFirstName(faker.name().firstName());
            employee.setLasttName(faker.name().lastName());
            employee.setAddress(faker.address().fullAddress());
            employee.setPhoneNumber(faker.phoneNumber().phoneNumber());
            employee.setEmail(faker.bothify("????##@gmail.com"));
            employee.setPersonalNumericCode(faker.number().randomNumber(13,true));
            employee.setHired(faker.bool().bool());

            dummyEmployee.add(employee);
        }
        return dummyEmployee;
    }

    public List<Company> createDummyCompanyList(){
        Faker faker = new Faker();
        List<Company> dummyCompany = new ArrayList<Company>();

        for (int i=0; i<50; i++) {
            Company company = new Company();
            company.setName(faker.name().name());
            company.setAddress(faker.address().fullAddress());
            company.setPhoneNumber(faker.phoneNumber().phoneNumber());
            company.setRegistrationNumber(faker.number().randomNumber(11,true));
            company.setEmail(faker.bothify("????##@gmail.com"));

            dummyCompany.add(company);
        }
          return dummyCompany;
    }
}
