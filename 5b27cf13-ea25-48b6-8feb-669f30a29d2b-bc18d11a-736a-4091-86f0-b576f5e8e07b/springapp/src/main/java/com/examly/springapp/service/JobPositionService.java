package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.JobPositionRepository;

@Service
public class JobPositionService {

    @Autowired
    private JobPositionRepository jobPositionRepository;

    // Create
    public JobPosition create(JobPosition jobPosition) {
        return jobPositionRepository.save(jobPosition);
    }

    // Read all
    public List<JobPosition> read() {
        return jobPositionRepository.findAll();
    }

    // Get by ID
    public Optional<JobPosition> getById(Long id) {
        return jobPositionRepository.findById(id);
    }

    // Update
    public JobPosition update(JobPosition jobPosition) {
        return jobPositionRepository.save(jobPosition);
    }

    // Delete
    public void delete(Long id) {
        jobPositionRepository.deleteById(id);
    }

    public List<JobPosition> searchByTitle(String keyword) {
        return jobPositionRepository.findByPositionTitleContainingIgnoreCase(keyword);
    }
}
