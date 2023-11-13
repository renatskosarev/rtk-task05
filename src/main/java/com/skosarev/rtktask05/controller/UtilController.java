package com.skosarev.rtktask05.controller;

import com.skosarev.rtktask05.dataload.CSVDataLoader;
import com.skosarev.rtktask05.dataload.DataLoader;
import com.skosarev.rtktask05.service.GroupService;
import com.skosarev.rtktask05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class UtilController {
    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public UtilController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("load-data/")
    public String loadDataToDatabase() {
        DataLoader dataLoader = new CSVDataLoader(
                "C:\\Users\\skosa\\Desktop\\rtk-task05\\src\\main\\resources\\students.csv",
                studentService,
                groupService
        );
        dataLoader.loadData();

        return "created";
    }
}
