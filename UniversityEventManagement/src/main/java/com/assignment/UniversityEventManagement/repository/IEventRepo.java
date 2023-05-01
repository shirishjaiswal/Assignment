package com.assignment.UniversityEventManagement.repository;

import com.assignment.UniversityEventManagement.model.Event;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IEventRepo extends JpaRepository<Event, Integer> {

    @Modifying
    @Query(value = "Select * from event where date = :date", nativeQuery = true)
    Iterable<Event> getAllEventByDate(LocalDate date);

    @Modifying
    @Transactional
    @Query(value = "update event set location = :location where id = :id", nativeQuery = true)
    int updateEventSetLocationForId(@Param("location") String location, @Param("id") Integer id);
}
