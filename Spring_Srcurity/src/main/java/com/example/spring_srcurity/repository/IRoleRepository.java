package com.example.spring_srcurity.repository;


import com.example.spring_srcurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Set<Role> findByRole(String name);

}
