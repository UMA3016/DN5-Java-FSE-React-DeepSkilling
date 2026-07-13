package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

import jakarta.transaction.Transactional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Transactional
    public Country getCountry(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    // Add New Country
    @Transactional
    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    @Transactional
    public List<Country> searchCountry(String text){

        return countryRepository.findByNameContaining(text);

    }

    @Transactional
    public List<Country> searchCountrySorted(String text){

        return countryRepository.findByNameContainingOrderByNameAsc(text);

    }

    @Transactional
    public List<Country> getCountriesStartingWith(String alphabet){

        return countryRepository.findByNameStartingWith(alphabet);

    }
}