package com.aslanjavasky.servicefortutor.servicefortutor.repository


import com.aslanjavasky.servicefortutor.servicefortutor.entity.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepoJpa : JpaRepository<Topic, Long>