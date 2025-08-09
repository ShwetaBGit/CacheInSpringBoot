package com.sb.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.entity.EmpEntity;

@Repository
public interface EmpRepository extends JpaRepository<EmpEntity, Long> {

}
