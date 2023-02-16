package com.godstime.HRMS.app.repository;

import com.godstime.HRMS.app.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Integer> {

    List<Users> findByEmail(String email);
}
