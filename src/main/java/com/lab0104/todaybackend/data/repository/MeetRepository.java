package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.Category;
import com.lab0104.todaybackend.data.domain.Meet;
import com.lab0104.todaybackend.data.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetRepository extends JpaRepository<Meet, Long> {
    Page<Meet> findBySubCategory(Category category, Pageable pageable);
    Page<Meet> findByUser(User user, Pageable pageable);
    Page<Meet> findByTitleContaining(String keyword, Pageable pageable);
}

