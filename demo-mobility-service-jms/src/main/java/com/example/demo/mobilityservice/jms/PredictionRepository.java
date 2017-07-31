package com.example.demo.mobilityservice.jms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictionRepository extends CrudRepository<PredictionEntity, Long>{
}
