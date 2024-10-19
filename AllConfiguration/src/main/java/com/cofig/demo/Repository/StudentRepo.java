package com.cofig.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cofig.demo.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
