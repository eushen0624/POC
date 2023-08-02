package com.example.demo.repositories;

import com.example.demo.models.StudentAccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAccountRepository extends JpaRepository<StudentAccountModel,Integer> {

}
