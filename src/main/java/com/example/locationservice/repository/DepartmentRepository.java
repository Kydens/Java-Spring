package com.example.locationservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Department;
import com.example.locationservice.models.DTO.DepartmentDTO;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Department d WHERE d.office.office_id = :officeId")
    public void deleteByOfficeId(@Param("officeId") Integer officeId);

    @Query("""
        SELECT 
            new com.example.locationservice.models.DTO.DepartmentDTO(
                d.department_id, 
                d.department_name, 
                o.office_id
            )
        FROM Department d 
        JOIN d.office o
        WHERE d.department_id = ?1
            
    """)
    public DepartmentDTO get(Integer id);
}
