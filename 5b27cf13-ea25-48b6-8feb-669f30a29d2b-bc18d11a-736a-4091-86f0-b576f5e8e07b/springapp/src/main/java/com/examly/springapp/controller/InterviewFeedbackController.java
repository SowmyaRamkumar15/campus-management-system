package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.service.InterviewFeedbackService;

@RestController
@RequestMapping("/api/interview-feedbacks")
public class InterviewFeedbackController {

    @Autowired
    private InterviewFeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<InterviewFeedback> create(@RequestBody InterviewFeedback feedback) {
        return new ResponseEntity<>(feedbackService.create(feedback), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InterviewFeedback>> getAll() {
        List<InterviewFeedback> list = feedbackService.read();
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InterviewFeedback> getById(@PathVariable Long id) {
        return feedbackService.read().stream()
            .filter(f -> f.getFeedbackId().equals(id))
            .findFirst()
            .map(f -> new ResponseEntity<>(f, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InterviewFeedback> update(@PathVariable Long id, @RequestBody InterviewFeedback feedback) {
        InterviewFeedback updated = feedbackService.update(id, feedback);
        if (updated == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<List<InterviewFeedback>> getByJobApplication(@PathVariable Long id) {
        List<InterviewFeedback> list = feedbackService.getByJobApplicationId(id);
        if (list.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
