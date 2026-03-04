package com.lnd.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/users")
public class UserController {

    private JdbcTemplate jdbcTemplate;

    @GetMapping("/search")
    public String searchUser(@RequestParam String username) {

        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        return jdbcTemplate.queryForObject(query, String.class);
    }
}