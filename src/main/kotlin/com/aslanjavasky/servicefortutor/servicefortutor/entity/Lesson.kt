package com.aslanjavasky.servicefortutor.servicefortutor.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import java.time.LocalDate


@Entity
data class Lesson(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val date: LocalDate,

    @ManyToMany(cascade = [CascadeType.ALL])
    val students: MutableList<Student>,

    @ManyToOne(cascade = [CascadeType.ALL])
    var topic: Topic
)
