package com.skosarev.rtktask05.controller;

import com.skosarev.rtktask05.dataload.CSVDataLoader;
import com.skosarev.rtktask05.service.GroupService;
import com.skosarev.rtktask05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class UtilController {
    @Value("${csv.path}")
    private String csvPathname;
    private final StudentService studentService;
    private final GroupService groupService;

    @Autowired
    public UtilController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @PostMapping("load-data/")
    public void loadDataToDatabase() {
        CSVDataLoader dataLoader = new CSVDataLoader(studentService, groupService);
        dataLoader.setPathname(csvPathname);
        dataLoader.loadData();
    }

    @GetMapping("health/")
    public ResponseEntity<Void> health() {
        return ResponseEntity.ok().build();
    }
}
