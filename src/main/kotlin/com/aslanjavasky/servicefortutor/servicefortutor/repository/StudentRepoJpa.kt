package com.aslanjavasky.servicefortutor.servicefortutor.repository

import com.aslanjavasky.servicefortutor.servicefortutor.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepoJpa : JpaRepository<Student, Long>