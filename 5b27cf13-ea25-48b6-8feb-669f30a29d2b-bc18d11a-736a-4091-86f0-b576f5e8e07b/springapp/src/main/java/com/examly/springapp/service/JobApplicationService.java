package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.JobApplication;
import com.examly.springapp.model.User;
import com.examly.springapp.model.JobPosition;
import com.examly.springapp.repository.JobApplicationRepository;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.repository.JobPositionRepository;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobPositionRepository jobPositionRepository;

    public JobApplication create(JobApplication jobApplication) {

        Optional<User> candidateOpt = userRepository.findById(jobApplication.getCandidate().getUserId());
        if(candidateOpt.isPresent()) {
            jobApplication.setCandidate(candidateOpt.get());
        }

        Optional<JobPosition> jobPositionOpt = jobPositionRepository.findById(jobApplication.getJobPosition().getPositionId());
        if(jobPositionOpt.isPresent()) {
            jobApplication.setJobPosition(jobPositionOpt.get());
        }

        return repository.save(jobApplication);
    }

    public List<JobApplication> read() {
        return repository.findAll();
    }

    public Optional<JobApplication> getById(Long id) {
        return repository.findById(id);
    }

    public JobApplication update(JobApplication jobApplication) {
        return repository.save(jobApplication);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
