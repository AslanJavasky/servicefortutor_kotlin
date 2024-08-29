package com.aslanjavasky.servicefortutor.servicefortutor.repository

import com.aslanjavasky.servicefortutor.servicefortutor.entity.Lesson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonRepoJpa : JpaRepository<Lesson, Long>