package com.lnd.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/search")
    public List<Map<String, Object>> searchUser(@RequestParam String username) {

        String query = "SELECT * FROM users WHERE username = ?";

        return jdbcTemplate.queryForList(query, username);
    }
}