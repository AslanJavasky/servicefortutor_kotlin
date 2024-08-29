package com.aslanjavasky.servicefortutor.servicefortutor.controller

import com.aslanjavasky.servicefortutor.servicefortutor.entity.Lesson
import com.aslanjavasky.servicefortutor.servicefortutor.entity.Student
import com.aslanjavasky.servicefortutor.servicefortutor.entity.Topic
import com.aslanjavasky.servicefortutor.servicefortutor.service.ApplicationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalDate

@Controller
class TutorpageController(
    private val service: ApplicationService
) {


    @GetMapping("/tutor_page")
    fun tutorPage(model: Model): String {
        model.addAttribute("topicList", service.getAllTopics())
        model.addAttribute("studentList", service.getAllStudents())
        return "tutor_page"
    }

    @PostMapping("/create_lesson")
    fun createLesson(
        @RequestParam("topic", required = false) topicId: Long?,
        @RequestParam("student", required = false) studentIds: Array<Long>?
    ): String {

        if (topicId == null || studentIds == null || studentIds.isEmpty()) {
            return "redirect:/tutor_page?error=missingParams"
        }

        val topic: Topic = service.getTopicById(topicId)
        if (topic == null) {
            return "redirect:/tutor_page?error=invalidTopic"
        }

        val uniqueStudentIds: Array<Long> = studentIds.distinct().toTypedArray()
        val studentList: MutableList<Student> = mutableListOf()
        uniqueStudentIds.forEach { studentId ->
            val student = service.getStudentById(studentId)
            studentList.add(student)
        }
        studentList.forEach { student ->
            student.coveredTopics.add(topic)
            service.updateStudent(student.id, student)
        }
        val lesson = Lesson(
            name = topic.name,
            date = LocalDate.now(),
            students = studentList,
            topic = topic
        )

        service.addLesson(lesson, topicId, uniqueStudentIds.toList())

        return "redirect:/tutor_page"
    }


}