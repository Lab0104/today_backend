package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
