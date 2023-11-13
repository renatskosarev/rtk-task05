package com.skosarev.rtktask05.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class StudentWithAverageMarkDTO {
    private String firstName;
    private String lastName;
    private int age;
    @JsonProperty("group")
    private GroupDTO groupDTO;
    private double averageMark;
}
