package com.example.peopleandpassports.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PeopleRepository extends CrudRepository<People, Long> {
        @Query("""
            select p from People p
            where 
                upper(p.name) like upper(concat('%', ?1, '%'))
                or upper(p.dop) like upper(concat('%', ?1, '%'))
            
               
    """)
        List<People> findByAll(String text);
    }

