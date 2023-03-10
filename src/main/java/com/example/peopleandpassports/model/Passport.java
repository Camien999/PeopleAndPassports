package com.example.peopleandpassports.model;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table(name = "passport")
public class Passport {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private People people;

    @Column(name = "pasport_number")
    private String pn;

    @Column(name = "date_of_expiry")
    private LocalDate dateOfExpiry;

    private String nationality;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Column(name = "type('P')")
    private String type;

    @Column(name = "ISO3166-1 alpha 2('__')")
    private String code;

    @Column(name = "sex('M','F')")
    private String sex;

    @Column(name = "place_of_brith")
    private String placeOfBrith;

    private String authority; // TODO: 2023 - collect each of the country's names and create EnumType, haha

    @Column(name = "holders_signature")
    private String holdersSignature;

    public Passport() {
    }

    public Passport(People people, String pn, LocalDate dateOfExpiry, String nationality, LocalDate dateOfBirth, String type, String code, String sex, String placeOfBrith, String authority, String holdersSignature) {
        this.people = people;
        this.pn = pn;
        this.dateOfExpiry = dateOfExpiry;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.type = type;
        this.code = code;
        this.sex = sex;
        this.placeOfBrith = placeOfBrith;
        this.authority = authority;
        this.holdersSignature = holdersSignature;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlaceOfBrith() {
        return placeOfBrith;
    }

    public void setPlaceOfBrith(String placeOfBrith) {
        this.placeOfBrith = placeOfBrith;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getHoldersSignature() {
        return holdersSignature;
    }

    public void setHoldersSignature(String holdersSignature) {
        this.holdersSignature = holdersSignature;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", people=" + people +
                ", pn='" + pn + '\'' +
                ", dateOfExpiry=" + dateOfExpiry +
                ", nationality='" + nationality + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", type=" + type +
                ", code='" + code + '\'' +
                ", sex=" + sex +
                ", placeOfBrith='" + placeOfBrith + '\'' +
                ", authority='" + authority + '\'' +
                ", holdersSignature=" + holdersSignature +
                '}';
    }
}