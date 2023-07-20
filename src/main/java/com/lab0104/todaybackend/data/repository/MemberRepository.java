package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.Meet;
import com.lab0104.todaybackend.data.domain.Member;
import com.lab0104.todaybackend.data.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Member> findByMeet(Meet meet, Pageable pageable);

}
