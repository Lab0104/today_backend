package com.lab0104.todaybackend.data.repository;

import com.lab0104.todaybackend.data.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    // JpaRepo는 <Entity 클래스, PK 타입> 을 사용한다.
    // Jpa는 Paging, Query, Crud, Repository를 상속받고 있으므로, 기본적인
    // 메서드들은 부모 인터페이스로부터 super 처리 되어 넘어온다.
}
