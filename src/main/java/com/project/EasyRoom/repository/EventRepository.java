package com.project.EasyRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.EasyRoom.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

}
