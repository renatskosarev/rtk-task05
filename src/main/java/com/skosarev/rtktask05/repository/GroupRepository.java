package com.skosarev.rtktask05.repository;

import com.skosarev.rtktask05.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    boolean existsByName(String name);

    Group findByName(String name);
}
