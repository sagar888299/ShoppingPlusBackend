package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.MentorRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.exception.ResourceNotFoundException;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.MentorModel;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/mentors")
public class MentorController {

    @Autowired
    private MentorRepository mentorRepository;
    

    @GetMapping
    public List<MentorModel> getAllMentors() {
        return mentorRepository.findAll();
    }

    @PostMapping
    public MentorModel createMentor(@RequestBody MentorModel mentor) {
        return mentorRepository.save(mentor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentorModel> updateMentor(@PathVariable Long id, @RequestBody MentorModel mentorDetails) {
        MentorModel mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor not found with id :" + id));

        mentor.setFirstName(mentorDetails.getFirstName());
        mentor.setLastName(mentorDetails.getLastName());
        mentor.setEmailId(mentorDetails.getEmailId());

        MentorModel updatedMentor = mentorRepository.save(mentor);
        return ResponseEntity.ok(updatedMentor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMentor(@PathVariable Long id) {
        MentorModel mentor = mentorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentor not found with id :" + id));

        mentorRepository.delete(mentor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}