package com.skosarev.rtktask05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class StudentDTO {
    private String firstName;
    private String lastName;
    private int age;
    @JsonProperty("group")
    private GroupDTO groupDTO;

    private int mathematics;
    private int geometry;
    private int informatics;
    private int physics;
    private int russian;
    private int literature;

    public StudentDTO(String firstName, String lastName, int age, GroupDTO groupDTO) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.groupDTO = groupDTO;
    }
}
