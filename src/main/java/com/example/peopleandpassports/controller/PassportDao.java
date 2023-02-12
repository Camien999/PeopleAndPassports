package com.example.peopleandpassports.controller;

import com.example.peopleandpassports.model.Passport;
import com.example.peopleandpassports.model.PassportRepository;
import com.example.peopleandpassports.model.People;
import com.example.peopleandpassports.model.PeopleRepository;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class PassportDao implements PassportRepository {

    private PassportRepository passportRepository;

    public PassportDao(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }
    @Transactional
    public void addPassports (Passport passport) {
        passportRepository.save(passport);
    }
    @Transactional
    public Iterable<Passport> getAllPassports() {
        return passportRepository.findAll();
    }

    public List<People> searchPassportBy(Optional<String> searchText) {
        List<People> result = new LinkedList<>();

        if (searchText.isPresent()) {
            result = passportRepository.findByAll(searchText.get());
        }

        return result.isEmpty()
                ? List.of()
                : List.copyOf(result);
    }

    @Override
    public List<People> findByAll(String text) {
        return null;
    }

    @Override
    public <S extends Passport> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Passport> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Passport> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Passport> findAll() {
        return null;
    }

    @Override
    public Iterable<Passport> findAllById(Iterable<Long> longs) {
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
    public void delete(Passport entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Passport> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
