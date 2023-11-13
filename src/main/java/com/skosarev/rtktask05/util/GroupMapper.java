package com.skosarev.rtktask05.util;

import com.skosarev.rtktask05.dto.GroupDTO;
import com.skosarev.rtktask05.model.Group;

public class GroupMapper {
    public static GroupDTO convertToDTO(Group group) {
        return new GroupDTO(
                group.getId(),
                group.getName()
        );
    }

    public static Group convertToGroup(GroupDTO dto) {
        return new Group(
                dto.getId(),
                dto.getName()
        );
    }
}
