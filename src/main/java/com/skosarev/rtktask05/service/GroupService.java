package com.skosarev.rtktask05.service;

import com.skosarev.rtktask05.dto.StudentWithAverageMarkDTO;
import com.skosarev.rtktask05.model.Group;
import com.skosarev.rtktask05.repository.GroupRepository;
import com.skosarev.rtktask05.repository.StudentRepository;
import com.skosarev.rtktask05.util.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GroupService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public List<StudentWithAverageMarkDTO> getAllStudentsWithAverageMarkDTO(int groupId) {
        return studentRepository.findAllByGroupId(groupId)
                .stream()
                .map(StudentMapper::convertToStudentWithAvgMarkDTO)
                .toList();
    }

    @Transactional
    public void create(Group group) {
        groupRepository.save(group);
    }
}
