package com.aslanjavasky.servicefortutor.servicefortutor.service

import com.aslanjavasky.servicefortutor.servicefortutor.entity.Lesson
import com.aslanjavasky.servicefortutor.servicefortutor.entity.Student
import com.aslanjavasky.servicefortutor.servicefortutor.entity.StudyModule
import com.aslanjavasky.servicefortutor.servicefortutor.entity.Topic
import com.aslanjavasky.servicefortutor.servicefortutor.repository.LessonRepoJpa
import com.aslanjavasky.servicefortutor.servicefortutor.repository.StudentRepoJpa
import com.aslanjavasky.servicefortutor.servicefortutor.repository.StudyModuleRepoJpa
import com.aslanjavasky.servicefortutor.servicefortutor.repository.TopicRepoJpa
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class ApplicationService(
    private val studyModuleRepo: StudyModuleRepoJpa,
    private val topicRepo: TopicRepoJpa,
    private val studentRepo: StudentRepoJpa,
    private val lessonRepo: LessonRepoJpa
) {

    @Transactional
    fun addStudyModule(studyModule: StudyModule) =
        studyModuleRepo.save(studyModule);

    @Transactional
    fun deleteStudyModel(studyModule: StudyModule) =
        studyModuleRepo.delete(studyModule)

    @Transactional
    fun renameStudyModule(moduleId: Long, newName: String): StudyModule? {
        return studyModuleRepo.findById(moduleId)
            .map { module ->
                module.name = newName
                studyModuleRepo.save(module)
            }
            .orElse(null)
    }

    @Transactional
    fun getAllStudyModules() = studyModuleRepo.findAll()

    @Transactional
    fun getStudyModuleById(id: Long) = studyModuleRepo.findById(id).get()


    @Transactional
    fun addTopicToStudyModule(moduleId: Long, topic: Topic): Topic? {
        return studyModuleRepo.findById(moduleId)
            .map { studyModule ->
                topic.studyModule = studyModule
                topicRepo.save(topic)
            }.orElse(null)
    }

    @Transactional
    fun addTopicListToStudyModule(moduleId: Long, topicList: List<Topic>): List<Topic>? {
        return studyModuleRepo.findById(moduleId)
            .map { studyModule ->
                topicList.forEach { it.studyModule = studyModule }
                topicRepo.saveAll(topicList)
            }.orElse(null)
    }

    @Transactional
    fun deleteTopic(topic: Topic) = topicRepo.delete(topic)

    @Transactional
    fun renameTopic(topicId: Long, newName: String): Topic? {
        return topicRepo.findById(topicId)
            .map { topic ->
                topic.name = newName
                topicRepo.save(topic)
            }.orElse(null)
    }

    @Transactional
    fun getAllTopics() = topicRepo.findAll()

    @Transactional
    fun getTopicById(topicId: Long): Topic =topicRepo.findById(topicId).get()

    @Transactional
    fun addStudent(student: Student) = studentRepo.save(student)

    @Transactional
    fun deleteStudent(student: Student) = studentRepo.delete(student)

    @Transactional
    fun updateStudent(studentId: Long, updatedStudent: Student): Student? {
        return studentRepo.findById(studentId)
            .map { existingStudent ->
                existingStudent.apply {
                    name = updatedStudent.name
                    lastname = updatedStudent.lastname
                    email = updatedStudent.email
                    city = updatedStudent.city
                    password = updatedStudent.password
                    registrationDate = updatedStudent.registrationDate
                    birthday = updatedStudent.birthday
                    telegram = updatedStudent.telegram
                    coveredTopics = updatedStudent.coveredTopics
                    lessons = updatedStudent.lessons
                }
                studentRepo.save(existingStudent)
            }
            .orElse(null)
    }

    @Transactional
    fun getAllStudents() = studentRepo.findAll()

    @Transactional
    fun getStudentById(studentId: Long): Student=studentRepo.findById(studentId).get()

    @Transactional
    fun addLesson(lesson: Lesson, topicId: Long, studentIds: List<Long>): Lesson? {
        return topicRepo.findById(topicId)
            .map { topic ->
                lesson.topic = topic
                studentIds.mapNotNull { studentRepo.findById(it).orElse(null) }
                    .forEach { lesson.students.add(it) }
                lessonRepo.save(lesson)
            }
            .orElse(null)
    }




}