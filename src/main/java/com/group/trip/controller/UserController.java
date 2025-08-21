package com.group.trip.controller;

import com.group.trip.entity.Itinerary;
import com.group.trip.entity.SearchCriteria;
import com.group.trip.service.SearchService;
import com.group.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService service;

}
