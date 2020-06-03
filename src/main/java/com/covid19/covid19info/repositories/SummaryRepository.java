package com.covid19.covid19info.repositories;

import com.covid19.covid19info.models.Summary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends CrudRepository<Summary, Long> {
    Summary findTopByOrderByIdDesc();
}
