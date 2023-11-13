package com.skosarev.rtktask05.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @Column(name = "math")
    private int math;

    @Column(name = "geometry")
    private int geometry;

    @Column(name = "informatics")
    private int informatics;

    @Column(name = "physics")
    private int physics;

    @Column(name = "russian")
    private int russian;

    @Column(name = "literature")
    private int literature;

    public Student() {
    }

    public Student(String firstName, String lastName, int age, Group group, int math, int geometry, int informatics, int physics, int russian, int literature) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.math = math;
        this.geometry = geometry;
        this.informatics = informatics;
        this.physics = physics;
        this.russian = russian;
        this.literature = literature;
    }

    public Student(String firstName, String lastName, int age, Group group, int... grades) {
        this(firstName, lastName, age, group, grades[0], grades[1], grades[2], grades[3], grades[4], grades[5]);
    }



    public double averageMark() {
        return (physics + math + russian + literature + geometry + informatics) / 6.0;
    }

    public boolean isExcellentStudent() {
        return averageMark() == 5.0;
    }

    public String getFullName() {
        return String.format("%s %s", lastName, firstName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                '}';
    }
}
