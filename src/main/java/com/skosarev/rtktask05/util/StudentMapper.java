package com.skosarev.rtktask05.util;

import com.skosarev.rtktask05.dto.StudentDTO;
import com.skosarev.rtktask05.dto.StudentWithAverageMarkDTO;
import com.skosarev.rtktask05.model.Student;

public class StudentMapper {
    private StudentMapper() {}

    public static StudentDTO convertToDTO(Student student) {
        return new StudentDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                GroupMapper.convertToDTO(student.getGroup()),
                student.getMath(),
                student.getGeometry(),
                student.getInformatics(),
                student.getPhysics(),
                student.getRussian(),
                student.getLiterature()
        );
    }

    public static StudentWithAverageMarkDTO convertToStudentWithAvgMarkDTO(Student student) {
        return new StudentWithAverageMarkDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                GroupMapper.convertToDTO(student.getGroup()),
                student.averageMark()
        );
    }
}
