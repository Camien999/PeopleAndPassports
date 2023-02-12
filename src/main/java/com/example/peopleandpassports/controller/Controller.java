package com.example.peopleandpassports.controller;

import com.example.peopleandpassports.model.People;
import com.example.peopleandpassports.model.PeopleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class Controller implements PeopleRepository {

    private PeopleRepository peoplerepository;


    public Controller(PeopleRepository peoplerepository) {
        this.peoplerepository = peoplerepository;
    }





    @Transactional
    public Iterable<People> getAllPeople() {
       return peoplerepository.findAll();
  }



  //  public void removeContact(Long idx) {
  //      contactRepository.deleteById(idx);
  //  }

    @Override
    public <S extends People> S save(S entity) {
        return null;
    }

    @Override
    public <S extends People> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<People> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<People> findAll() {
        return null;
    }

    @Override
    public Iterable<People> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }


    @Override
    public void delete(People entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends People> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Transactional
    public void addPeople (People people) {
        peoplerepository.save(people);
    }

    // TODO: 2023. 02. 11. meghívni a menuben

    public List<People> searchPeople(Optional<String> searchText) {
        List<People> result = new LinkedList<>();

        if (searchText.isPresent()) {
            result = peoplerepository.findByAll(searchText.get());
        }

        return result.isEmpty()
                ? List.of()
                : List.copyOf(result);
    }

    @Override
    public List<People> findByAll(String text) {
        return null;
    }
}

