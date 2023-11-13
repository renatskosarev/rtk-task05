package com.skosarev.rtktask05.controller;

import com.skosarev.rtktask05.dto.StudentWithAverageMarkDTO;
import com.skosarev.rtktask05.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/groups/")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("{groupId}/average_marks")
    public List<StudentWithAverageMarkDTO> getAverageMarks(@PathVariable int groupId) {
        return groupService.getAllStudentsWithAverageMarkDTO(groupId);
    }
}
