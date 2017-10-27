package com.manjula.crud.repository;

import java.util.List;

import com.manjula.crud.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

    List<Privilege> findByIdIn(List<String> ids);

}
