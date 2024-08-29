package com.aslanjavasky.servicefortutor.servicefortutor.utils

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class StudentIdManager {

    @Value("\${student.id}")
    var studentId: Long = 0

}