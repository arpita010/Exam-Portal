package com.examportal.service.quiz;

import com.examportal.controller.quiz.request.QuizCreateRequest;
import com.examportal.controller.quiz.request.QuizUpdateRequest;
import com.examportal.controller.quiz.response.QuizResponse;
import com.examportal.data.entities.Quiz;
import com.examportal.repository.quiz.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class QuizService {
  private QuizRepo quizRepo;

  @Autowired
  QuizService(QuizRepo quizRepo) {
    this.quizRepo = quizRepo;
  }

  public QuizResponse create(QuizCreateRequest quizCreateRequest) {
    Quiz quiz = quizCreateRequest.toQuiz();
    Quiz savedQuiz = quizRepo.save(quiz);
    return new QuizResponse(savedQuiz);
  }

  public QuizResponse update(QuizUpdateRequest quizUpdateRequest) throws Exception {
    Optional<Quiz> opt = quizRepo.findById(quizUpdateRequest.getId());
    if (opt.isEmpty()) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "");
    Quiz quiz = quizUpdateRequest.toQuiz(opt.get());
    Quiz updatedQuiz = quizRepo.save(quiz);
    return new QuizResponse(updatedQuiz);
  }

  public void findRandomQuestions(Long numberOfQuestions) {}

  public Quiz findById(Long id) {
    return quizRepo.findById(id).orElse(null);
  }
}
