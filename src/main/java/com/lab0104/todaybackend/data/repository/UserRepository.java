package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.User;
import com.lab0104.todaybackend.data.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}