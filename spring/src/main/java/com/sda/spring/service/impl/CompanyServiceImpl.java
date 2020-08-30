package com.sda.spring.service.impl;

import com.sda.spring.model.Company;
import com.sda.spring.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

@Autowired
private CompanyRepository companyRepository;


    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company getById(Integer id) {
        Optional<Company> foundCompany =  companyRepository.findById(id);

        return foundCompany.get();
    }

    @Override
    public List<Company> getAll(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        Page<Company> pageResult = companyRepository.findAll(pageable);
        return pageResult.getContent();
    }
    @Override
    public List<Company> saveAll(List<Company> companyListList) {
        return (List<Company>) companyRepository.saveAll(companyListList);
    }
}
