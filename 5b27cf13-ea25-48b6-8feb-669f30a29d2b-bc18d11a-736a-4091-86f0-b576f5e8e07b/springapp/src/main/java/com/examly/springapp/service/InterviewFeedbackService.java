package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.InterviewFeedback;

public interface InterviewFeedbackService {
    InterviewFeedback create(InterviewFeedback feedback);
    List<InterviewFeedback> read();
    InterviewFeedback update(Long id, InterviewFeedback feedback);
    List<InterviewFeedback> getByJobApplicationId(Long id);
}
