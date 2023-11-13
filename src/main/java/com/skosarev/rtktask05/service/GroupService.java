package com.skosarev.rtktask05.service;

import com.skosarev.rtktask05.dto.StudentWithAverageMarkDTO;
import com.skosarev.rtktask05.model.Group;
import com.skosarev.rtktask05.repository.GroupRepository;
import com.skosarev.rtktask05.repository.StudentRepository;
import com.skosarev.rtktask05.util.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<StudentWithAverageMarkDTO> getAllStudentsDTO() {
        return studentRepository.findAll()
                .stream().
                map(StudentMapper::convertToStudentWithAvgMarkDTO)
                .toList();
    }

    public Group createIfNotExists(Group group) {
        if (groupRepository.existsByName(group.getName())) {
            return groupRepository.findByName(group.getName());
        }
        return groupRepository.save(group);
    }
}
