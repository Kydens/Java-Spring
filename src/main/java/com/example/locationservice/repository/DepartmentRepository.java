package com.example.locationservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Department d WHERE d.office.office_id = :officeId")
    public void deleteByOfficeId(@Param("officeId") Integer officeId);
}
