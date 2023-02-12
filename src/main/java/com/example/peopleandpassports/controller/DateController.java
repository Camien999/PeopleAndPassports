package com.example.peopleandpassports.controller;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DateController {
    private final PassportDao passportDao;

    public DateController(PassportDao passportDao) {
        this.passportDao = passportDao;
    }


    @PostMapping("/local-date")
    public void localDate(@RequestParam("localDate")
                          @DateTimeFormat(pattern = "yyyy-MMM-dd") LocalDateTime localDateTime) {
    }
}
