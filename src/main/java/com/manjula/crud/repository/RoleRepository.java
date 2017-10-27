package com.manjula.crud.repository;

import com.manjula.crud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Optional<Role> findByName(String name);

}
