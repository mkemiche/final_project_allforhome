package io.allforhome.services;

import io.allforhome.models.RSAgency;
import io.allforhome.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author mkemiche
 * @created 05/06/2021
 */

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void saveCompany(RSAgency rsCompany){
        companyRepository.save(rsCompany);
    }

    public Optional<RSAgency> getUserById(Long id){
        return companyRepository.findById(id);
    }

    public List<RSAgency> getAllUser(){
        return companyRepository.findAll();
    }

}
