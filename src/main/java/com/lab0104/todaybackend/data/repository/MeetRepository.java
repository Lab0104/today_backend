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
//    List<Meet> findByName(String name, Sort sort);
//    Page<Meet> findAll(Meet meet, Pageable pageable);
    Page<Meet> findById(long id, Pageable pageable);


    Page<Meet> findByCategory(Category category, Pageable pageable);
    Page<Meet> findByUser(User user, Pageable pageable);
}

