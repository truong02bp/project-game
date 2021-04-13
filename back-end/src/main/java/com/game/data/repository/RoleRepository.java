package com.game.data.repository;

import com.game.data.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.name = :name")
    Role findRoleByName(@Param("name") String name);

    @Query("SELECT r.name FROM Role r")
    List<String> getAllRoleNames();
}
