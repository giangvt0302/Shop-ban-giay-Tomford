package com.shop.tomford.auth.repository;

import com.shop.tomford.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    @Query("SELECT r FROM Role r WHERE r.normalizedName = ?1")
    Optional<Role> findByName(String name);

}
