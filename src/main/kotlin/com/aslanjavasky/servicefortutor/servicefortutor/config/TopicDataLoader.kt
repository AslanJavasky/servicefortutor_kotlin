package com.aslanjavasky.servicefortutor.servicefortutor.config

import com.aslanjavasky.servicefortutor.servicefortutor.entity.StudyModule
import com.aslanjavasky.servicefortutor.servicefortutor.entity.Topic
import com.aslanjavasky.servicefortutor.servicefortutor.service.ApplicationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class TopicDataLoader @Autowired constructor(
    private val service: ApplicationService
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        service.addStudyModule(StudyModule(1L, "Java language", emptyList()))
        service.addStudyModule(StudyModule(2L, "Kotlin language", emptyList()))
        service.addStudyModule(StudyModule(3L, "PostgreSQL DB", emptyList()))
        service.addStudyModule(StudyModule(4L, "Spring framework", emptyList()))

        // Topic By module "Java language"
        service.addTopicToStudyModule(1L, Topic(1L, "Syntax Java", ArrayList(), service.getStudyModuleById(1L), ArrayList()))
        service.addTopicToStudyModule(1L, Topic(2L, "OOP", ArrayList(), service.getStudyModuleById(1L), ArrayList()))
        service.addTopicToStudyModule(1L, Topic(3L, "Java Collections", ArrayList(), service.getStudyModuleById(1L), ArrayList()))
        service.addTopicToStudyModule(1L, Topic(4L, "Exceptions", ArrayList(), service.getStudyModuleById(1L), ArrayList()))
        service.addTopicToStudyModule(1L, Topic(5L, "Generics", ArrayList(), service.getStudyModuleById(1L), ArrayList()))
        service.addTopicToStudyModule(1L, Topic(6L, "Streams", ArrayList(), service.getStudyModuleById(1L), ArrayList()))
        service.addTopicToStudyModule(1L, Topic(7L, "Concurrent in Java", ArrayList(), service.getStudyModuleById(1L), ArrayList()))

        // Topic By module "Kotlin language"
        service.addTopicToStudyModule(2L, Topic(8L, "Syntax Kotlin", ArrayList(), service.getStudyModuleById(2L), ArrayList()))
        service.addTopicToStudyModule(2L, Topic(9L, "OOP", ArrayList(), service.getStudyModuleById(2L), ArrayList()))
        service.addTopicToStudyModule(2L, Topic(10L, "Kotlin Collections", ArrayList(), service.getStudyModuleById(2L), ArrayList()))
        service.addTopicToStudyModule(2L, Topic(11L, "Exceptions", ArrayList(), service.getStudyModuleById(2L), ArrayList()))
        service.addTopicToStudyModule(2L, Topic(12L, "Generics", ArrayList(), service.getStudyModuleById(2L), ArrayList()))
        service.addTopicToStudyModule(2L, Topic(13L, "Kotlin Extensions", ArrayList(), service.getStudyModuleById(2L), ArrayList()))
        service.addTopicToStudyModule(2L, Topic(14L, "Coroutines", ArrayList(), service.getStudyModuleById(2L), ArrayList()))

        // Topic для PostgreSQL
        service.addTopicToStudyModule(3L, Topic(15L, "Introduction to PostgreSQL", ArrayList(), service.getStudyModuleById(3L), ArrayList()))
        service.addTopicToStudyModule(3L, Topic(16L, "PostgreSQL Data Types", ArrayList(), service.getStudyModuleById(3L), ArrayList()))
        service.addTopicToStudyModule(3L, Topic(17L, "PostgreSQL Queries", ArrayList(), service.getStudyModuleById(3L), ArrayList()))
        service.addTopicToStudyModule(3L, Topic(18L, "PostgreSQL Indexes", ArrayList(), service.getStudyModuleById(3L), ArrayList()))
        service.addTopicToStudyModule(3L, Topic(19L, "PostgreSQL Joins", ArrayList(), service.getStudyModuleById(3L), ArrayList()))

        // Topic для Spring framework
        service.addTopicToStudyModule(4L, Topic(20L, "Spring Boot Basics", ArrayList(), service.getStudyModuleById(4L), ArrayList()))
        service.addTopicToStudyModule(4L, Topic(21L, "Spring Data JPA", ArrayList(), service.getStudyModuleById(4L), ArrayList()))
        service.addTopicToStudyModule(4L, Topic(22L, "Spring Security", ArrayList(), service.getStudyModuleById(4L), ArrayList()))
        service.addTopicToStudyModule(4L, Topic(23L, "Spring MVC", ArrayList(), service.getStudyModuleById(4L), ArrayList()))
        service.addTopicToStudyModule(4L, Topic(24L, "Spring Cloud", ArrayList(), service.getStudyModuleById(4L), ArrayList()))

    }
}