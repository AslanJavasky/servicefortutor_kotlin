package com.aslanjavasky.servicefortutor.servicefortutor.controller

import com.aslanjavasky.servicefortutor.servicefortutor.entity.Student
import com.aslanjavasky.servicefortutor.servicefortutor.service.ApplicationService
import com.aslanjavasky.servicefortutor.servicefortutor.utils.StudentIdManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class StudentdashboardController @Autowired constructor(
    private val service: ApplicationService,
    private val studentIdManager: StudentIdManager
) {

    @GetMapping("/student_dashboard")
    fun studentPersonalAccount(
        @RequestParam(value = "student_id", required = false) studentId: Long,
        model: Model
    ): String {

        val student: Student = service.getStudentById(studentId)
        model.addAttribute("student", student)
        model.addAttribute("studentIdFromProperties", studentIdManager.studentId)
        return "student_dashboard"
    }
}

