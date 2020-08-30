package com.sda.spring.service.impl;

import com.sda.spring.model.Company;
import java.util.List;

public interface CompanyService {


    Company create(Company company) ;
    List<Company> saveAll(List<Company> companyList);
    Company getById(Integer id);
    List<Company> getAll(Integer pageNo, Integer pageSize, String sortBy);
}
