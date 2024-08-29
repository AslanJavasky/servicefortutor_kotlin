package com.aslanjavasky.servicefortutor.servicefortutor.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
data class StudyModule(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    var name: String,

    @OneToMany(mappedBy = "studyModule", cascade = [CascadeType.ALL])
    val topics: List<Topic>
)
