package com.skosarev.rtktask05.controller;

import com.skosarev.rtktask05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("students/{studentId}/marks/{subjectName}")
    public void updateMark(@PathVariable int studentId,
                           @PathVariable String subjectName,
                           @RequestParam int newMark) {
        studentService.updateMark(studentId, subjectName, newMark);
    }
}
