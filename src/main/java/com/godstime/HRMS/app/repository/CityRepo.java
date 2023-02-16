package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {
    City getCityById(int id);
}
