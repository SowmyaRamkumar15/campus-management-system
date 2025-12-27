package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.InterviewFeedback;
import com.examly.springapp.repository.InterviewFeedbackRepository;

@Service
public class InterviewFeedbackServiceImpl implements InterviewFeedbackService {

    @Autowired
    private InterviewFeedbackRepository feedbackRepo;

    @Override
    public InterviewFeedback create(InterviewFeedback feedback) {
        return feedbackRepo.save(feedback);
    }

    @Override
    public List<InterviewFeedback> read() {
        return feedbackRepo.findAll();
    }

    @Override
    public InterviewFeedback update(Long id, InterviewFeedback feedback) {
        Optional<InterviewFeedback> existing = feedbackRepo.findById(id);
        if (existing.isPresent()) {
            InterviewFeedback obj = existing.get();
            obj.setContent(feedback.getContent());
            obj.setIsInternal(feedback.getIsInternal());
            obj.setInterviewRound(feedback.getInterviewRound());
            return feedbackRepo.save(obj);
        }
        return null;
    }

    @Override
    public List<InterviewFeedback> getByJobApplicationId(Long id) {
        return feedbackRepo.findByJobApplicationApplicationId(id);
    }
}
