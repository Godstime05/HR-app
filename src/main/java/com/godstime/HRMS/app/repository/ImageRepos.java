package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.Employer;
import com.godstime.HRMS.app.utils.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepos extends JpaRepository<Image, Integer> {

}
