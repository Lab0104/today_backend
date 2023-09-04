package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {

}
