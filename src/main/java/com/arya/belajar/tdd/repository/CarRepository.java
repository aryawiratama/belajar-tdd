package com.arya.belajar.tdd.repository;

import com.arya.belajar.tdd.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends PagingAndSortingRepository<Car, String>{

    @Query("SELECT c FROM Car c WHERE c.name=:name")
    Car findByName(@Param("name") String name);
}
