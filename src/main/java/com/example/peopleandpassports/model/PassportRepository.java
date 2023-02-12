package com.example.peopleandpassports.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface PassportRepository extends CrudRepository<Passport, Long> {
    @Query("""
            select p from Passport  p
            where 
                upper(p.pn) like upper(concat('%', ?1, '%'))
                or upper(p.nationality) like upper(concat('%', ?1, '%'))
                or upper(p.type) like upper(concat('%', ?1, '%'))
                or upper(p.placeOfBrith) like upper(concat('%', ?1, '%'))
                or upper(p.authority) like upper(concat('%', ?1, '%'))
                or upper(p.holdersSignature) like upper(concat('%', ?1, '%'))
    """)
    List<People> findByAll(String text);

}
