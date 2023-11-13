package com.skosarev.rtktask05.dataload;

import com.skosarev.rtktask05.model.Group;
import com.skosarev.rtktask05.model.Student;
import com.skosarev.rtktask05.service.GroupService;
import com.skosarev.rtktask05.service.StudentService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVDataLoader implements DataLoader {
    private final String pathname;
    private final StudentService studentService;
    private final GroupService groupService;

    public CSVDataLoader(String pathname, StudentService studentService, GroupService groupService) {
        this.pathname = pathname;
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @Override
    public void loadData() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathname)))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");

                String lastname = values[0];
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String groupName = values[3];
                int[] grades = Arrays.stream(values).skip(4).mapToInt(Integer::parseInt).toArray();

                Group group = groupService.createIfNotExists(new Group(groupName));
                studentService.create(new Student(name, lastname, age, group, grades));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            System.exit(404);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
