package com.covid19.covid19info.repositories;

import com.covid19.covid19info.models.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesRepository extends CrudRepository<Country, Long> {

    Country findBySlug(String slug);
    Country findByCountry(String country);

    @Override
    List<Country> findAll();
}
