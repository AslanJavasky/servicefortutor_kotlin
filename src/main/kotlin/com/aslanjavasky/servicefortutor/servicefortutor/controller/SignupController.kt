package com.aslanjavasky.servicefortutor.servicefortutor.controller

import com.aslanjavasky.servicefortutor.servicefortutor.entity.Student
import com.aslanjavasky.servicefortutor.servicefortutor.service.ApplicationService
import com.aslanjavasky.servicefortutor.servicefortutor.utils.StudentIdManager
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SignupController(
    @Autowired private val service: ApplicationService,
    @Autowired private val studentIdManager: StudentIdManager
) {

    @GetMapping("/sign_up")
    fun signUp(model: Model): String {
        model.addAttribute("student", Student())
        return "sign_up"
    }

    @PostMapping("/add_student")
    fun addStudent(
        @Valid student: Student,
        bindingResult: BindingResult
    ): String {
        if (bindingResult.hasErrors()){
            return "sign_up"
        }
        service.addStudent(student)
        studentIdManager.studentId=student.id
        return "redirect:/student_dashboard?student_id=${student.id}"
    }

}