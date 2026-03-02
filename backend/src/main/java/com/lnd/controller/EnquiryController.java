package com.lnd.controller;

import org.springframework.web.bind.annotation.*;
import com.lnd.repo.EnquiryRepository;
import com.lnd.model.Enquiry;

import java.util.List;

@RestController
@RequestMapping("/api/enquiries")
@CrossOrigin("*")
public class EnquiryController {

 private final EnquiryRepository repo;

 public EnquiryController(EnquiryRepository repo){
  this.repo = repo;
 }

 @PostMapping
 public Enquiry save(@RequestBody Enquiry enquiry){
  return repo.save(enquiry);
 }

 @GetMapping
 public List<Enquiry> getAll(){
  return repo.findAll();
 }
}
