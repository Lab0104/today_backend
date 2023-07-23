package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Long countByDepth(int depth);

    Page<Category> findByCategoryGroup(Category category, Pageable pageable);

    Page<Category> findByDepth(int depth, Pageable pageable);
}
