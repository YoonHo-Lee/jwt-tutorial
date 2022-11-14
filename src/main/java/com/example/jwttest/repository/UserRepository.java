package com.example.jwttest.repository;

import com.example.jwttest.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = "authorities")                        // 쿼리 수행시 lazy 조회가 아니고, Eager 조회로 authorities 정보를 같이 가져오게 됨.
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}