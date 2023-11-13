package com.skosarev.rtktask05.dataload;

import com.skosarev.rtktask05.model.Group;
import com.skosarev.rtktask05.model.Student;
import com.skosarev.rtktask05.service.GroupService;
import com.skosarev.rtktask05.service.StudentService;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CSVDataLoader {
    private String pathname;
    private final StudentService studentService;
    private final GroupService groupService;

    public CSVDataLoader(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    public void loadData() {
        Group[] groups = new Group[12];
        for (int i = 0; i < 12; i++) {
            groups[i] = new Group(String.valueOf(i + 1));
            groupService.create(groups[i]);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathname)))) {
            reader.readLine();
            String line;

            List<Student> students = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");

                String lastname = values[0];
                String name = values[1];
                int age = Integer.parseInt(values[2]);
                String groupName = values[3];
                int[] grades = Arrays.stream(values).skip(4).mapToInt(Integer::parseInt).toArray();

                students.add(new Student(name, lastname, age, groups[Integer.parseInt(groupName) - 1], grades));
                if (students.size() >= 10000) {
                    studentService.createAll(students);
                    students.clear();
                }
            }
            studentService.createAll(students);
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
