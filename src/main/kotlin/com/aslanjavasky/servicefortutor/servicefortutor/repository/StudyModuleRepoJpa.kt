package com.aslanjavasky.servicefortutor.servicefortutor.repository

import com.aslanjavasky.servicefortutor.servicefortutor.entity.StudyModule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyModuleRepoJpa : JpaRepository<StudyModule, Long>