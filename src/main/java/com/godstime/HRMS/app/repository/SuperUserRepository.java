package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.SuperUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperUserRepository extends JpaRepository<SuperUser, Integer> {
    SuperUser getById(int Id);
}
