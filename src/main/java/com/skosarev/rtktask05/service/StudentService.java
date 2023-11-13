package com.skosarev.rtktask05.service;

import com.skosarev.rtktask05.model.Student;
import com.skosarev.rtktask05.repository.GroupRepository;
import com.skosarev.rtktask05.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public void create(Student student) {
        studentRepository.save(student);
    }
}
