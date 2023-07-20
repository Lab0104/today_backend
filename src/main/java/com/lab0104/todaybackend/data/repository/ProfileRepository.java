package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, String> {

}
