package com.fs.passweb.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassRepository extends JpaRepository<PassEntity, Integer> {
    @Query(value = "select p from PassEntity p " +
            "join fetch p.packageEntity " +
            "where p.userId = :userId " +
            "order by p.endedAt desc nulls first ") // nulls first 는 endedAt 이 null 일때 먼저 나오게 함
    List<PassEntity> findByUserId(String userId);
}
