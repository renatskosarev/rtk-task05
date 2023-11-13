package com.skosarev.rtktask05.service;

import com.skosarev.rtktask05.model.Student;
import com.skosarev.rtktask05.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) {
        studentRepository.save(student);
    }

    public void createAll(List<Student> students) {
        studentRepository.saveAllAndFlush(students);
    }

    public void updateMark(int studentId, String subjectName, int newMark) {
        if (! (newMark >= 1 && newMark <= 5)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New mark should be between 1 and 5");
        }

        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Student with id = %s was not found", studentId))
        );

        try {
            Field field = student.getClass().getDeclaredField(subjectName);
            field.setAccessible(true);
            field.set(student, newMark);

        } catch (IllegalAccessException e) {
            throw new ResponseStatusException(HttpStatus.valueOf(500));
        } catch (NoSuchFieldException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Subject with name = %s not exists", subjectName));
        }

        studentRepository.save(student);
    }
}
